package com.haulmont.testtask.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "banks")
public class Bank extends AbstractBaseEntity {

    @OneToMany(mappedBy = "bank", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @OrderBy("interestRate DESC")
    @JsonManagedReference
    private List<Credit> credits;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @OrderBy("FIO")
    @JsonManagedReference
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
