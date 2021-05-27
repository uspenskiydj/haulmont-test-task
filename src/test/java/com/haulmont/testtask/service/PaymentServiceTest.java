package com.haulmont.testtask.service;

import com.haulmont.testtask.model.Payment;
import com.haulmont.testtask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.UUID;
import static com.haulmont.testtask.testdata.PaymentTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentServiceTest extends AbstractServiceTest {

    @Autowired
    private PaymentService service;

    @Test
    void create() {
        Payment created = service.create(getNew());
        UUID newId = created.getId();
        Payment newPayment = getNew();
        newPayment.setId(newId);
        PAYMENT_MATCHER.assertMatch(created, newPayment);
        PAYMENT_MATCHER.assertMatch(service.get(newId), newPayment);
    }

    @Test
    void delete() {
        service.delete(PAYMENT1_ID);
        assertThrows(NotFoundException.class, () -> service.get(PAYMENT1_ID));
    }

    @Test
    void get() {
        Payment payment = service.get(PAYMENT3_ID);
        PAYMENT_MATCHER.assertMatch(payment, PAYMENT3);
    }

    @Test
    void getAll() {
        List<Payment> all = service.getAll();
        PAYMENT_MATCHER.assertMatch(all, PAYMENT1, PAYMENT2, PAYMENT3);
    }

    @Test
    void update() {
        Payment updated = getUpdated();
        service.update(updated);
        PAYMENT_MATCHER.assertMatch(service.get(PAYMENT1_ID), getUpdated());
    }
}