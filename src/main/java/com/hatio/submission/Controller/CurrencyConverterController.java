package com.hatio.submission.Controller;

import com.hatio.submission.Model.CurrencyConverterRequest;
import com.hatio.submission.Model.CurrencyConverterResponse;
import com.hatio.submission.Service.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency-converter")
public class CurrencyConverterController {

    @Autowired
    private CurrencyConverterService currencyConverterService;

    @PostMapping("/convert")
    public CurrencyConverterResponse convertCurrency(@RequestBody CurrencyConverterRequest request) {
        return currencyConverterService.convertCurrency(request);
    }
}