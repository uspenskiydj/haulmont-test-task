package com.haulmont.testtask.testdata;

import com.haulmont.testtask.TestMatcher;
import com.haulmont.testtask.model.Customer;
import java.util.UUID;
import static com.haulmont.testtask.testdata.BankTestData.BANK1;
import static com.haulmont.testtask.testdata.BankTestData.BANK2;

public class CustomerTestData {
    public static final TestMatcher<Customer> CUSTOMER_MATCHER = TestMatcher.usingEqualsComparator(Customer.class);

    public static final UUID CUSTOMER1_ID = UUID.fromString("0101ba8b-39c1-4043-8bde-6155ef55a159");
    public static final UUID CUSTOMER2_ID = UUID.fromString("9a651751-1320-4888-af38-6ef79483e283");
    public static final UUID CUSTOMER3_ID = UUID.fromString("f896611b-7d98-4dd2-b88a-105f2f19111f");

    public static final Customer CUSTOMER1 = new Customer(CUSTOMER1_ID, "fio1", "phone1", "email1", "pas1", BANK1);
    public static final Customer CUSTOMER2 = new Customer(CUSTOMER2_ID, "fio2", "phone2", "email2", "pas2", BANK1);
    public static final Customer CUSTOMER3 = new Customer(CUSTOMER3_ID, "fio3", "phone3", "email3", "pas3", BANK2);

    public static Customer getNew() {
        return new Customer(null, "fio_new", "phone_new", "email_new","pas_new", BANK1);
    }

    public static Customer getUpdated() {
        Customer updated = new Customer(CUSTOMER1);
        updated.setFio("fio_updated");
        updated.setPhoneNumber("phone_updated");
        updated.setEmail("email_updated");
        updated.setPassportNumber("pas_updated");
        updated.setBank(BANK2);
        return updated;
    }
}
