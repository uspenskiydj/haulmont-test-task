package com.haulmont.testtask.model;

import java.math.BigDecimal;
import java.util.List;

public class CreditProposal extends AbstractBaseEntity {

    private Customer customer;

    private Credit credit;

    private BigDecimal creditAmount;

    private List<Payment> payments;

    public CreditProposal() {
    }

    public CreditProposal(Customer customer, Credit credit, BigDecimal creditAmount, List<Payment> payments) {
        this.customer = customer;
        this.credit = credit;
        this.creditAmount = creditAmount;
        this.payments = payments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
