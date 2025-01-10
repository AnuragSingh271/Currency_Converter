package com.hatio.submission.Service;

import com.hatio.submission.Model.CurrencyConverterRequest;
import com.hatio.submission.Model.CurrencyConverterResponse;
import com.hatio.submission.Model.ExchangeRateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterServiceTest {

    @InjectMocks
    private CurrencyConverterService currencyConverterService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void convertCurrency_validConversion() {
        CurrencyConverterRequest request = new CurrencyConverterRequest();
        request.setFrom("USD");
        request.setTo("EUR");
        request.setAmount(100);

        ExchangeRateResponse mockApiResponse = new ExchangeRateResponse();
        mockApiResponse.getRates().put("EUR", 0.85);

        CurrencyConverterResponse response = currencyConverterService.convertCurrency(request);

        assertEquals(85, response.getConvertedAmount(), 0.01);
    }

    @Test
    void convertCurrency_invalidCurrencyCode() {
        CurrencyConverterRequest request = new CurrencyConverterRequest();
        request.setFrom("USD");
        request.setTo("XYZ");
        request.setAmount(100);

        CurrencyConverterResponse response = currencyConverterService.convertCurrency(request);

        assertEquals(0, response.getConvertedAmount());
        assertEquals("Invalid currency code.", response.getErrorMessage());
    }
}
