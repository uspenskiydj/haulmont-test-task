package com.haulmont.testtask.service;

import com.haulmont.testtask.model.CreditProposal;
import com.haulmont.testtask.testdata.CreditProposalTestData;
import com.haulmont.testtask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.UUID;
import static com.haulmont.testtask.testdata.CreditProposalTestData.*;
import static com.haulmont.testtask.testdata.CreditTestData.*;
import static com.haulmont.testtask.testdata.CustomerTestData.*;
import static org.junit.jupiter.api.Assertions.*;

class CreditProposalServiceTest extends AbstractServiceTest {

    @Autowired
    private CreditProposalService service;

    @Test
    void create() {
        CreditProposal created = service.create(CreditProposalTestData.getNew(), CUSTOMER1_ID, CREDIT2_ID);
        UUID newId = created.getId();
        CreditProposal newCreditProposal = CreditProposalTestData.getNew();
        newCreditProposal.setId(newId);
        CREDIT_PROPOSAL_MATCHER.assertMatch(created, newCreditProposal);
        CREDIT_PROPOSAL_MATCHER.assertMatch(service.get(newId), newCreditProposal);
    }

    @Test
    void delete() {
        service.delete(CREDIT_PROPOSAL1_ID);
        assertThrows(NotFoundException.class, () -> service.get(CREDIT_PROPOSAL1_ID));
    }

    @Test
    void get() {
        CreditProposal creditProposal = service.get(CREDIT_PROPOSAL3_ID);
        CREDIT_PROPOSAL_MATCHER.assertMatch(creditProposal, CREDIT_PROPOSAL3);
    }

    @Test
    void getAll() {
        List<CreditProposal> all = service.getAll();
        CREDIT_PROPOSAL_MATCHER.assertMatch(all, CREDIT_PROPOSAL1, CREDIT_PROPOSAL2, CREDIT_PROPOSAL3);
    }

    @Test
    void update() {
        CreditProposal updated = CreditProposalTestData.getUpdated();
        service.update(updated, CUSTOMER1_ID, CREDIT1_ID);
        CREDIT_PROPOSAL_MATCHER.assertMatch(service.get(CREDIT_PROPOSAL1_ID), CreditProposalTestData.getUpdated());
    }
}