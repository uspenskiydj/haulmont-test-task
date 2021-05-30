package com.haulmont.testtask.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

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
    @NotNull
    private Bank bank;

    public Credit() {
    }

    public Credit(BigDecimal limit, Double interestRate, Bank bank) {
        this.limit = limit;
        this.interestRate = interestRate;
        this.bank = bank;
    }

    public Credit(UUID id, BigDecimal limit, Double interestRate, Bank bank) {
        super(id);
        this.limit = limit;
        this.interestRate = interestRate;
        this.bank = bank;
    }

    public Credit(Credit c) {
        this(c.getId(), c.getLimit(), c.getInterestRate(), c.getBank());
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
