package com.haulmont.testtask.util;

import com.haulmont.testtask.model.Credit;
import com.haulmont.testtask.model.CreditProposal;
import com.haulmont.testtask.model.Payment;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentsUtil {

    public static final Integer MONTHS_AMOUNT = 12;

    public static List<Payment> createNew(CreditProposal creditProposal, Credit credit) {
        List<Payment> payments = new ArrayList<>();
        BigDecimal creditBalance = creditProposal.getCreditAmount();
        LocalDate date = LocalDate.now();
        double monthlyInterestRatePercent = credit.getInterestRate() / 12;
        double monthlyInterestRate = credit.getInterestRate() / 12 / 100;

        BigDecimal totalAmountPerMonth = creditBalance.multiply(BigDecimal.valueOf(monthlyInterestRate *
                Math.pow((1 + monthlyInterestRate), MONTHS_AMOUNT) /
                (Math.pow((1 + monthlyInterestRate), MONTHS_AMOUNT) - 1)));

        for (int i = 0; i < MONTHS_AMOUNT; i++) {
            BigDecimal amountOfInterestRepayment = creditBalance.multiply(BigDecimal.valueOf(monthlyInterestRatePercent));
            BigDecimal amountOfCreditBodyRepayment = totalAmountPerMonth.subtract(amountOfInterestRepayment);
            payments.add(new Payment(date, totalAmountPerMonth, amountOfCreditBodyRepayment, amountOfInterestRepayment, creditProposal));
            date = date.plusMonths(1);
            creditBalance = creditBalance.subtract(totalAmountPerMonth);
        }
        return payments;
    }
}
