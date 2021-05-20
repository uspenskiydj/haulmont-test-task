package com.haulmont.testtask.model;

import org.hibernate.validator.constraints.Range;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
}
