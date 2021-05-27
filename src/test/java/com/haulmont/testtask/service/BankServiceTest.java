package com.haulmont.testtask.service;

import com.haulmont.testtask.model.Bank;
import com.haulmont.testtask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.UUID;
import static com.haulmont.testtask.testdata.BankTestData.*;
import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest extends AbstractServiceTest {

    @Autowired
    private BankService service;

    @Test
    void create() {
        Bank created = service.create(getNew());
        UUID newId = created.getId();
        Bank newBank = getNew();
        newBank.setId(newId);
        BANK_MATCHER.assertMatch(created, newBank);
        BANK_MATCHER.assertMatch(service.get(newId), newBank);
    }

    @Test
    void delete() {
        service.delete(BANK1_ID);
        assertThrows(NotFoundException.class, () -> service.get(BANK1_ID));
    }

    @Test
    void get() {
        Bank bank = service.get(BANK2_ID);
        BANK_MATCHER.assertMatch(bank, BANK2);
    }

    @Test
    void getAll() {
        List<Bank> all = service.getAll();
        BANK_MATCHER.assertMatch(all, BANK1, BANK2);
    }
}