package com.zinbiel.mars.attributes;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

/**
 * Created by elias on 04.09.17.
 */
@Embeddable
public class Price {

    private String currency;
    private Float price;

    public Price() {
    }

    public Price(String currency, Float price) {
        this.currency = currency;
        this.price = price;
    }

    @Basic
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
