package com.haulmont.testtask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payment extends AbstractBaseEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "total_amount", nullable = false)
    @NotNull
    @Range(min = 0)
    private BigDecimal totalAmount;

    @Column(name = "amount_of_credit_body_repayment", nullable = false)
    @NotNull
    @Range(min = 0)
    private BigDecimal amountOfCreditBodyRepayment;

    @Column(name = "amount_of_interest_repayment", nullable = false)
    @NotNull
    @Range(min = 0)
    private BigDecimal amountOfInterestRepayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_proposal_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    @NotNull
    private CreditProposal creditProposal;

    public Payment() {
    }

    public Payment(LocalDate date, BigDecimal totalAmount,
                   BigDecimal amountOfCreditBodyRepayment, BigDecimal amountOfInterestRepayment) {
        this.date = date;
        this.totalAmount = totalAmount;
        this.amountOfCreditBodyRepayment = amountOfCreditBodyRepayment;
        this.amountOfInterestRepayment = amountOfInterestRepayment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public CreditProposal getCreditProposal() {
        return creditProposal;
    }

    public void setCreditProposal(CreditProposal creditProposal) {
        this.creditProposal = creditProposal;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", totalAmount=" + totalAmount +
                ", amountOfCreditBodyRepayment=" + amountOfCreditBodyRepayment +
                ", amountOfInterestRepayment=" + amountOfInterestRepayment +
                '}';
    }
}
