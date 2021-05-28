package com.haulmont.testtask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Credit_proposals")
public class CreditProposal extends AbstractBaseEntity {

    @Column(name = "credit_amount", nullable = false)
    @NotNull
    @Range(min = 0)
    private BigDecimal creditAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "credit_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Credit credit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "creditProposal", cascade = CascadeType.REMOVE)
    @OrderBy("date DESC")
    @JsonManagedReference
    private List<Payment> payments;

    public CreditProposal() {
    }

    public CreditProposal(BigDecimal creditAmount, Customer customer, Credit credit, List<Payment> payments) {
        this.creditAmount = creditAmount;
        this.customer = customer;
        this.credit = credit;
        this.payments = payments;
    }

    public CreditProposal(UUID id, BigDecimal creditAmount, Customer customer, Credit credit, List<Payment> payments) {
        super(id);
        this.creditAmount = creditAmount;
        this.customer = customer;
        this.credit = credit;
        this.payments = payments;
    }

    public CreditProposal(CreditProposal c) {
        this(c.getId(), c.getCreditAmount(), c.getCustomer(), c.getCredit(), c.getPayments());
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

    @Override
    public String toString() {
        return "CreditProposal{" +
                "id=" + id +
                ", customer=" + customer +
                ", credit=" + credit +
                ", creditAmount=" + creditAmount +
                '}';
    }
}
