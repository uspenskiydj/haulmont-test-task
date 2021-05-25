package com.haulmont.testtask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "credits")
public class Credit extends AbstractBaseEntity {

    @Column(name = "limit", nullable = false)
    @NotNull
    @Range(min = 0)
    private BigDecimal limit;

    @Column(name = "interest_rate", nullable = false)
    @NotNull
    @Range(min = 0, max = 100)
    private Double interestRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    @NotNull
    private Bank bank;

    public Credit() {
    }

    public Credit(BigDecimal limit, Double interestRate) {
        this.limit = limit;
        this.interestRate = interestRate;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", limit=" + limit +
                ", interestRate=" + interestRate +
                '}';
    }
}
