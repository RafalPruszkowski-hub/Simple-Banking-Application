package com.example.simple_banking_app.exchange_rate_provider;


import com.example.simple_banking_app.account.api.dto.CurrencyType;
import com.example.simple_banking_app.exchange_rate_provider.api.exception.ExchangeRateNotFound;
import com.example.simple_banking_app.exchange_rate_provider.api.dto.ExchangeRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ExchangeRateProviderUseCase {
    /***
     * There should be an extra layer that hide the response from NBP API and return more generic
     * type, so we can return more generic response from it instead of NBP api response, and also catch connections
     * errors in this place
     */
    private final ExchangeRateProviderApiConnector connector;

    private static final Logger log = LoggerFactory.getLogger(ExchangeRateProviderUseCase.class);

    ExchangeRateProviderUseCase(ExchangeRateProviderApiConnector connector) {
        this.connector = connector;
    }

    public ExchangeRate getExchangeRate(CurrencyType to) {
        try {
            return connector.getExchangeRate(to)
                    .orElseThrow(() -> new ExchangeRateNotFound(String.format("Exchange rate not found %s", to.name())))
                    .rates()
                    .stream()
                    .findFirst()
                    .map(e -> new ExchangeRate(e.mid()))
                    .orElseThrow(() -> new ExchangeRateNotFound(String.format("Exchange rate not found %s", to.name())));
            //TODO catch more specific exceptions
        } catch (Exception exception) {
            log.error("Error occurred", exception);
            throw new ExchangeRateNotFound(String.format("Exchange rate not found %s", to.name()), exception);
        }
    }

}
