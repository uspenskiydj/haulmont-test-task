package com.haulmont.testtask.service;

import com.haulmont.testtask.model.Customer;
import com.haulmont.testtask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.UUID;
import static com.haulmont.testtask.testdata.CustomerTestData.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest extends AbstractServiceTest {

    @Autowired
    private CustomerService service;

    @Test
    void create() {
        Customer created = service.create(getNew());
        UUID newId = created.getId();
        Customer newCustomer = getNew();
        newCustomer.setId(newId);
        CUSTOMER_MATCHER.assertMatch(created, newCustomer);
        CUSTOMER_MATCHER.assertMatch(service.get(newId), newCustomer);
    }

    @Test
    void delete() {
        service.delete(CUSTOMER1_ID);
        assertThrows(NotFoundException.class, () -> service.get(CUSTOMER1_ID));
    }

    @Test
    void get() {
        Customer customer = service.get(CUSTOMER3_ID);
        CUSTOMER_MATCHER.assertMatch(customer, CUSTOMER3);
    }

    @Test
    void getAll() {
        List<Customer> all = service.getAll();
        CUSTOMER_MATCHER.assertMatch(all, CUSTOMER1, CUSTOMER2, CUSTOMER3);
    }

    @Test
    void update() {
        Customer updated = getUpdated();
        service.update(updated);
        CUSTOMER_MATCHER.assertMatch(service.get(CUSTOMER1_ID), getUpdated());
    }
}