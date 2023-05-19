package com.example.simple_banking_app.exchange_rate_provider;

import com.example.simple_banking_app.account.api.dto.CurrencyType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(name = "ExchangeRateProviderApiConnector",
        url = "https://api.nbp.pl/api/",
        configuration = FeignConfiguration.class)
interface ExchangeRateNBPApiConnector extends ExchangeRateProviderApiConnector {

    @RequestMapping(method = RequestMethod.GET, value = "exchangerates/rates/a/${to}/", produces = "application/json")
    @Override
    Optional<ExchangeRateNBPApiResponse> getExchangeRate(CurrencyType to);
}