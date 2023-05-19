package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.dto.CurrencyType;
import com.example.simple_banking_app.account.api.dto.ExchangeCurrency;
import com.example.simple_banking_app.account.api.exceptions.ToBigExchangeRequestException;
import com.example.simple_banking_app.exchange_rate_provider.api.ExchangeRateProviderFacade;
import com.example.simple_banking_app.exchange_rate_provider.api.dto.ExchangeRate;
import jakarta.transaction.Transactional;

import java.util.UUID;


@Transactional
class ExchangeCurrencyUseCase {
    private final AccountRepository accountRepository;
    private final ExchangeRateProviderFacade exchangeRateProviderFacade;


    public ExchangeCurrencyUseCase(AccountRepository accountRepository, ExchangeRateProviderFacade exchangeRateProviderFacade) {
        this.accountRepository = accountRepository;
        this.exchangeRateProviderFacade = exchangeRateProviderFacade;
    }

    public void execute(ExchangeCurrency exchangeCurrency, UUID userId) {
        var account = accountRepository.getByUserId(userId);
        validate(account, exchangeCurrency);
        //TODO this is ready for a bit more then making conversion only to dollars but for now i will leave it like this
        var currencyExchangeRate = exchangeRateProviderFacade.getExchangeRate(CurrencyType.USD);
        account.exchangeCurrency(exchangeCurrency.from(), exchangeCurrency.to(), exchangeCurrency.amount(), calculateExchangeRate(currencyExchangeRate, exchangeCurrency));
    }

    private double calculateExchangeRate(ExchangeRate exchangeRate, ExchangeCurrency exchangeCurrency) {
        if (exchangeCurrency.from() == CurrencyType.PLN) {
            return 1 / exchangeRate.exchangeRate();
        }
        return exchangeRate.exchangeRate();
    }

    private void validate(AccountEntity account, ExchangeCurrency exchangeCurrency) {
        // TODO we can return potential errors from each validation and return them as a List of errors.
        validateIfNotTryingToExchangeToBigAmount(account, exchangeCurrency);
    }

    private void validateIfNotTryingToExchangeToBigAmount(AccountEntity account, ExchangeCurrency exchangeCurrency) {
        var currencyTypeAccount = account.getCurrencyTypeAccount(exchangeCurrency.from());
        if (currencyTypeAccount.getAmount() < exchangeCurrency.amount()) {
            throw new ToBigExchangeRequestException(String.format("Trying to conver %f while only %f is avialiable on account", exchangeCurrency.amount(), currencyTypeAccount.getAmount()));
        }
    }
}
