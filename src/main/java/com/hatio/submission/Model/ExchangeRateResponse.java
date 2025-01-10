package com.hatio.submission.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class ExchangeRateResponse {

    private Map<String, Double> rates;

}
