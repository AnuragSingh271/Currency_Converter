package com.hatio.submission.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CurrencyConverterResponse {

    private String from;
    private String to;
    private double amount;
    private double convertedAmount;
    private String errorMessage;


}