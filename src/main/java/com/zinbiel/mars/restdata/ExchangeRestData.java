package com.zinbiel.mars.restdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;

/**
 * Created by elias on 04.09.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRestData {

    private String base;
    private String date;
    private HashMap<String, Float> rates = new HashMap<>();

    public ExchangeRestData() {
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HashMap<String, Float> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Float> rates) {
        this.rates = rates;
    }
}
