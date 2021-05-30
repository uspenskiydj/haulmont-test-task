package com.haulmont.testtask.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "banks")
public class Bank extends AbstractBaseEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank", cascade = CascadeType.REMOVE)
    @OrderColumn(name = "interest_rate")
    private List<Credit> credits;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank", cascade = CascadeType.REMOVE)
    @OrderBy("fio")
    private List<Customer> customers;

    public Bank() {
    }

    public Bank(UUID id) {
        super(id);
    }

    public Bank(List<Credit> credits, List<Customer> customers) {
        this.credits = credits;
        this.customers = customers;
    }

    public Bank(UUID id, List<Credit> credits, List<Customer> customers) {
        super(id);
        this.credits = credits;
        this.customers = customers;
    }

    public Bank(Bank b) {
        this(b.getId(), b.getCredits(), b.getCustomers());
    }

    public Bank(String uuid) {
        super(UUID.fromString(uuid));
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

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
