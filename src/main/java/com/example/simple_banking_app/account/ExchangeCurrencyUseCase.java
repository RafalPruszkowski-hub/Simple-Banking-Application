package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.dto.CurrencyType;
import com.example.simple_banking_app.account.api.dto.ExchangeCurrency;
import com.example.simple_banking_app.account.api.exceptions.ToBigExchangeRequestException;
import com.example.simple_banking_app.exchange_rate_provider.api.ExchangeRateProviderFacade;
import com.example.simple_banking_app.exchange_rate_provider.api.dto.ExchangeRate;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Transactional
class ExchangeCurrencyUseCase {
    private final AccountRepository accountRepository;
    private final ExchangeRateProviderFacade exchangeRateProviderFacade;
    private static final Logger log = LoggerFactory.getLogger(ExchangeCurrencyUseCase.class);

    public ExchangeCurrencyUseCase(AccountRepository accountRepository, ExchangeRateProviderFacade exchangeRateProviderFacade) {
        this.accountRepository = accountRepository;
        this.exchangeRateProviderFacade = exchangeRateProviderFacade;
    }

    public void execute(ExchangeCurrency exchangeCurrency, String userPesel) {
        var account = accountRepository.getByUserPesel(userPesel);
        validate(account, exchangeCurrency);
        //TODO this is ready for a bit more then making conversion only to and from dollars but for now i will leave it like this
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
        try {
            validateIfNotTryingToExchangeToBigAmount(account, exchangeCurrency);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    private void validateIfNotTryingToExchangeToBigAmount(AccountEntity account, ExchangeCurrency exchangeCurrency) {
        var currencyTypeAccount = account.getCurrencyTypeAccount(exchangeCurrency.from());
        if (currencyTypeAccount.getAmount() < exchangeCurrency.amount()) {
            throw new ToBigExchangeRequestException(String.format("Trying to conver %f while only %f is avialiable on account", exchangeCurrency.amount(), currencyTypeAccount.getAmount()));
        }
    }
}
