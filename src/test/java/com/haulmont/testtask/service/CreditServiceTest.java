package com.haulmont.testtask.service;

import com.haulmont.testtask.model.Credit;
import com.haulmont.testtask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.UUID;
import static com.haulmont.testtask.testdata.CreditTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreditServiceTest extends AbstractServiceTest {

    @Autowired
    private CreditService service;

    @Test
    void create() {
        Credit created = service.create(getNew());
        UUID newId = created.getId();
        Credit newCredit = getNew();
        newCredit.setId(newId);
        CREDIT_MATCHER.assertMatch(created, newCredit);
        CREDIT_MATCHER.assertMatch(service.get(newId), newCredit);
    }

    @Test
    void delete() {
        service.delete(CREDIT1_ID);
        assertThrows(NotFoundException.class, () -> service.get(CREDIT1_ID));
    }

    @Test
    void get() {
        Credit credit = service.get(CREDIT3_ID);
        CREDIT_MATCHER.assertMatch(credit, CREDIT3);
    }

    @Test
    void getAll() {
        List<Credit> all = service.getAll();
        CREDIT_MATCHER.assertMatch(all, CREDIT1, CREDIT2, CREDIT3);
    }

    @Test
    void update() {
        Credit updated = getUpdated();
        service.update(updated);
        CREDIT_MATCHER.assertMatch(service.get(CREDIT1_ID), getUpdated());
    }
}