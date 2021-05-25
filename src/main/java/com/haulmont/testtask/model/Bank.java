package com.haulmont.testtask.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "banks")
public class Bank extends AbstractBaseEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank", cascade = CascadeType.REMOVE)
    @OrderBy("interestRate DESC")
    @JsonManagedReference
    private List<Credit> credits;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank", cascade = CascadeType.REMOVE)
    @OrderBy("FIO")
    @JsonManagedReference
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

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                '}';
    }
}
