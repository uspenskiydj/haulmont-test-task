package com.haulmont.testtask.model;

import java.util.List;

public class Bank extends AbstractBaseEntity {

    private List<Credit> credits;

    private List<Customer> customers;

    public Bank() {
    }

    public Bank(List<Credit> credits, List<Customer> customers) {
        this.credits = credits;
        this.customers = customers;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
