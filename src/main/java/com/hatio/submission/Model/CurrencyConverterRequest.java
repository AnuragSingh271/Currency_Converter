package com.hatio.submission.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CurrencyConverterRequest {

    private String from;
    private String to;
    private double amount;

}
