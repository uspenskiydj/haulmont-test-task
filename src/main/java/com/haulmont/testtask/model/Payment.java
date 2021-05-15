package com.haulmont.testtask.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment extends AbstractBaseEntity {

    private LocalDateTime date;

    private BigDecimal totalAmount;

    private BigDecimal amountOfCreditBodyRepayment;

    private BigDecimal amountOfInterestRepayment;

    public Payment() {
    }

    public Payment(LocalDateTime date, BigDecimal totalAmount,
                   BigDecimal amountOfCreditBodyRepayment, BigDecimal amountOfInterestRepayment) {
        this.date = date;
        this.totalAmount = totalAmount;
        this.amountOfCreditBodyRepayment = amountOfCreditBodyRepayment;
        this.amountOfInterestRepayment = amountOfInterestRepayment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getAmountOfCreditBodyRepayment() {
        return amountOfCreditBodyRepayment;
    }

    public void setAmountOfCreditBodyRepayment(BigDecimal amountOfCreditBodyRepayment) {
        this.amountOfCreditBodyRepayment = amountOfCreditBodyRepayment;
    }

    public BigDecimal getAmountOfInterestRepayment() {
        return amountOfInterestRepayment;
    }

    public void setAmountOfInterestRepayment(BigDecimal amountOfInterestRepayment) {
        this.amountOfInterestRepayment = amountOfInterestRepayment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "date=" + date +
                ", totalAmount=" + totalAmount +
                ", amountOfCreditBodyRepayment=" + amountOfCreditBodyRepayment +
                ", amountOfInterestRepayment=" + amountOfInterestRepayment +
                '}';
    }
}
