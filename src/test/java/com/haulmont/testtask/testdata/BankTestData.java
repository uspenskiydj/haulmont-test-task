package com.haulmont.testtask.testdata;

import com.haulmont.testtask.TestMatcher;
import com.haulmont.testtask.model.Bank;
import java.util.UUID;

public class BankTestData {
    public static final TestMatcher<Bank> BANK_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Bank.class, "customers", "credits");

    public static final UUID BANK1_ID = UUID.fromString("0d347392-b14f-4ac0-9ba8-21e25dc1eb5f");
    public static final UUID BANK2_ID = UUID.fromString("6e2dffa7-01a8-44a7-a6bb-bae04dd58e88");

    public static final Bank BANK1 = new Bank(BANK1_ID);
    public static final Bank BANK2 = new Bank(BANK2_ID);

    public static Bank getNew() {
        return new Bank();
    }
}
