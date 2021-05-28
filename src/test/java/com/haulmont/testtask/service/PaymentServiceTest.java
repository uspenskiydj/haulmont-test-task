package com.haulmont.testtask.service;

import com.haulmont.testtask.model.Payment;
import com.haulmont.testtask.testdata.PaymentTestData;
import com.haulmont.testtask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.UUID;
import static com.haulmont.testtask.testdata.CreditProposalTestData.*;
import static com.haulmont.testtask.testdata.PaymentTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentServiceTest extends AbstractServiceTest {

    @Autowired
    private PaymentService service;

    @Test
    void create() {
        Payment created = service.create(PaymentTestData.getNew(), CREDIT_PROPOSAL1_ID);
        UUID newId = created.getId();
        Payment newPayment = PaymentTestData.getNew();
        newPayment.setId(newId);
        PAYMENT_MATCHER.assertMatch(created, newPayment);
        PAYMENT_MATCHER.assertMatch(service.get(newId, CREDIT_PROPOSAL1_ID), newPayment);
    }

    @Test
    void delete() {
        service.delete(PAYMENT1_ID, CREDIT_PROPOSAL1_ID);
        assertThrows(NotFoundException.class, () -> service.get(PAYMENT1_ID, CREDIT_PROPOSAL1_ID));
    }

    @Test
    void get() {
        Payment payment = service.get(PAYMENT3_ID, CREDIT_PROPOSAL3_ID);
        PAYMENT_MATCHER.assertMatch(payment, PAYMENT3);
    }

    @Test
    void getAll() {
        List<Payment> all = service.getAll(CREDIT_PROPOSAL1_ID);
        PAYMENT_MATCHER.assertMatch(all, PAYMENT1);
    }

    @Test
    void update() {
        Payment updated = PaymentTestData.getUpdated();
        service.update(updated, CREDIT_PROPOSAL3_ID);
        PAYMENT_MATCHER.assertMatch(service.get(PAYMENT1_ID, CREDIT_PROPOSAL3_ID), PaymentTestData.getUpdated());
    }
}