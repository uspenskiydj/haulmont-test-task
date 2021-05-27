package com.haulmont.testtask.testdata;

import com.haulmont.testtask.TestMatcher;
import com.haulmont.testtask.model.Payment;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;
import static com.haulmont.testtask.testdata.CreditProposalTestData.*;

public class PaymentTestData {
    public static final TestMatcher<Payment> PAYMENT_MATCHER = TestMatcher.usingEqualsComparator(Payment.class);

    public static final UUID PAYMENT1_ID = UUID.fromString("02135a2c-ef9b-4fa8-a1d2-dd6cdaa845cc");
    public static final UUID PAYMENT2_ID = UUID.fromString("6aac9ed1-436e-4e85-902b-510a8b63822c");
    public static final UUID PAYMENT3_ID = UUID.fromString("ae7dc11b-f0f5-4377-afb4-cf2ba376d48d");

    public static final Payment PAYMENT1 = new Payment(PAYMENT1_ID, LocalDate.of(2021, Month.JANUARY, 25), BigDecimal.valueOf(100.5), BigDecimal.valueOf(90.3), BigDecimal.valueOf(10.2), CREDIT_PROPOSAL1);
    public static final Payment PAYMENT2 = new Payment(PAYMENT2_ID, LocalDate.of(2021, Month.FEBRUARY, 25), BigDecimal.valueOf(200.5), BigDecimal.valueOf(180.3), BigDecimal.valueOf(20.2), CREDIT_PROPOSAL2);
    public static final Payment PAYMENT3 = new Payment(PAYMENT3_ID, LocalDate.of(2021, Month.MARCH, 25), BigDecimal.valueOf(300.5), BigDecimal.valueOf(270.3), BigDecimal.valueOf(30.2), CREDIT_PROPOSAL3);

    public static Payment getNew() {
        return new Payment(null, LocalDate.of(2021, Month.APRIL, 25), BigDecimal.valueOf(400.5), BigDecimal.valueOf(360.3), BigDecimal.valueOf(40.2), CREDIT_PROPOSAL2);
    }

    public static Payment getUpdated() {
        Payment updated = new Payment(PAYMENT1);
        updated.setDate(LocalDate.of(2021, Month.MAY, 25));
        updated.setTotalAmount(BigDecimal.valueOf(500.5));
        updated.setAmountOfCreditBodyRepayment(BigDecimal.valueOf(450.3));
        updated.setAmountOfInterestRepayment(BigDecimal.valueOf(50.2));
        updated.setCreditProposal(CREDIT_PROPOSAL3);
        return updated;
    }
}
