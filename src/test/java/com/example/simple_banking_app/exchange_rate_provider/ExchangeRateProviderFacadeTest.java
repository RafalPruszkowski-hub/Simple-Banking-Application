package com.example.simple_banking_app.exchange_rate_provider;

import com.example.simple_banking_app.account.api.dto.CurrencyType;
import com.example.simple_banking_app.exchange_rate_provider.api.exception.ExchangeRateNotFound;
import com.example.simple_banking_app.exchange_rate_provider.api.ExchangeRateProviderFacade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


@ExtendWith(MockitoExtension.class)
class ExchangeRateProviderFacadeTest {
    ExchangeRateProviderFacade facade;
    ExchangeRateProviderUseCase useCase;
    ExchangeRateProviderApiConnector exchangeRateProviderApiConnector;

    @BeforeEach
    void init() {
        this.exchangeRateProviderApiConnector = Mockito.mock(ExchangeRateProviderApiConnector.class);
        this.useCase = new ExchangeRateProviderUseCase(exchangeRateProviderApiConnector);
        this.facade = new ExchangeRateProviderFacadeImpl(useCase);
    }

    @DisplayName("Errors ")
    @Nested
    class errors {

        void connectionErrors(){
            //TODO
        }

        @DisplayName("throws not found on null value")
        @Test
        void returnedNull() {
            Mockito.when(exchangeRateProviderApiConnector.getExchangeRate(CurrencyType.USD))
                    .thenReturn(Optional.empty());

            assertThatThrownBy(() -> facade.getExchangeRate(CurrencyType.USD))
                    .isInstanceOf(ExchangeRateNotFound.class)
                    .hasMessageContaining("Exchange rate not found USD");

        }

        @DisplayName("throws not found on empty list inside Response")
        @Test
        void returnedEmptyListOfValues() {
            var exchangeRateNBPApiResponse = new ExchangeRateNBPApiResponse(List.of());
            Mockito.when(exchangeRateProviderApiConnector.getExchangeRate(CurrencyType.USD))
                    .thenReturn(Optional.of(exchangeRateNBPApiResponse));

            assertThatThrownBy(() -> facade.getExchangeRate(CurrencyType.USD))
                    .isInstanceOf(ExchangeRateNotFound.class)
                    .hasMessageContaining("Exchange rate not found USD");

        }
    }

    @DisplayName("Accept ")
    @Nested
    class accept {

        @DisplayName("Returned proper value for ExchangeRateNBPApiResponse")
        @Test
        void ok() {
            //GIVEN
            var ExchangeRate = new ExchangeRateNBPApiResponse.ExchangeRate(1);
            var exchangeRateNBPApiResponse = new ExchangeRateNBPApiResponse(List.of(ExchangeRate));
            Mockito.when(exchangeRateProviderApiConnector.getExchangeRate(CurrencyType.USD))
                    .thenReturn(Optional.of(exchangeRateNBPApiResponse));
            //WHEN
            var tmp = facade.getExchangeRate(CurrencyType.USD);
            //THEN
            Assertions.assertThat(tmp.exchangeRate()).isEqualTo(1);
        }
    }
}