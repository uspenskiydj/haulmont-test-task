package com.haulmont.testtask.model;

import java.math.BigDecimal;

public class Credit extends AbstractBaseEntity {

    private BigDecimal limit;

    private String interestRate;

    public Credit() {
    }

    public Credit(BigDecimal limit, String interestRate) {
        this.limit = limit;
        this.interestRate = interestRate;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }
}
