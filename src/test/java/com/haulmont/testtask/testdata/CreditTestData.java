package com.haulmont.testtask.testdata;

import com.haulmont.testtask.TestMatcher;
import com.haulmont.testtask.model.Credit;
import java.math.BigDecimal;
import java.util.UUID;
import static com.haulmont.testtask.testdata.BankTestData.*;

public class CreditTestData {
    public static final TestMatcher<Credit> CREDIT_MATCHER = TestMatcher.usingEqualsComparator(Credit.class);

    public static final UUID CREDIT1_ID = UUID.randomUUID();
    public static final UUID CREDIT2_ID = UUID.randomUUID();
    public static final UUID CREDIT3_ID = UUID.randomUUID();

    public static final Credit CREDIT1 = new Credit(CREDIT1_ID, new BigDecimal("100.5"), 10.5, BANK1);
    public static final Credit CREDIT2 = new Credit(CREDIT2_ID, new BigDecimal("200.5"), 20.5, BANK1);
    public static final Credit CREDIT3 = new Credit(CREDIT3_ID, new BigDecimal("300.5"), 30.5, BANK2);

    public static Credit getNew() {
        return new Credit(null, new BigDecimal("400.5"), 40.5, BANK1);
    }

    public static Credit getUpdated() {
        Credit updated = new Credit(CREDIT1);
        updated.setInterestRate(40.5);
        updated.setLimit(new BigDecimal("400.5"));
        updated.setBank(BANK2);
        return updated;
    }
}
