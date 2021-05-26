package com.haulmont.testtask.testdata;

import com.haulmont.testtask.model.Bank;
import java.util.UUID;

public class BankTestData {
    public static final UUID BANK1_ID = UUID.randomUUID();
    public static final UUID BANK2_ID = UUID.randomUUID();

    public static final Bank BANK1 = new Bank(BANK1_ID);
    public static final Bank BANK2 = new Bank(BANK2_ID);
}
