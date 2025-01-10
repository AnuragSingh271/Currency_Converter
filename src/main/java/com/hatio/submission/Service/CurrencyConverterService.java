package com.hatio.submission.Service;

import com.hatio.submission.Model.CurrencyConverterRequest;
import com.hatio.submission.Model.CurrencyConverterResponse;
import com.hatio.submission.Model.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyConverterService {

    @Value("${exchange.api.key}")
    private String apiKey;

    @Value("${exchange.api.url}")
    private String apiUrl;

    public CurrencyConverterResponse convertCurrency(CurrencyConverterRequest request) {
        String url = apiUrl + request.getFrom() + "?apikey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        CurrencyConverterResponse response = new CurrencyConverterResponse();

        try {
            ExchangeRateResponse apiResponse = restTemplate.getForObject(url, ExchangeRateResponse.class);

            if (apiResponse != null) {
                if (apiResponse.getRates().containsKey(request.getTo())) {
                    double conversionRate = apiResponse.getRates().get(request.getTo());
                    double convertedAmount = request.getAmount() * conversionRate;

                    response.setFrom(request.getFrom());
                    response.setTo(request.getTo());
                    response.setAmount(request.getAmount());
                    response.setConvertedAmount(convertedAmount);
                } else {
                    response.setFrom(request.getFrom());
                    response.setTo(request.getTo());
                    response.setAmount(request.getAmount());
                    response.setConvertedAmount(0);
                    throw new IllegalArgumentException("Invalid currency code.");
                }
            } else {
                throw new IllegalStateException("External API is invalid");
            }
        } catch (HttpClientErrorException | IllegalArgumentException e) {
            response.setFrom(request.getFrom());
            response.setTo(request.getTo());
            response.setAmount(request.getAmount());
            response.setConvertedAmount(0);
            response.setErrorMessage("Error: " + e.getMessage());
        } catch (Exception e) {
            response.setFrom(request.getFrom());
            response.setTo(request.getTo());
            response.setAmount(request.getAmount());
            response.setConvertedAmount(0);
            response.setErrorMessage("An unexpected error occurred: " + e.getMessage());
        }

        return response;
    }
}
