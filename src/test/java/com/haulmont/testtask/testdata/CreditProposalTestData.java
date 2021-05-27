package com.haulmont.testtask.testdata;

import com.haulmont.testtask.TestMatcher;
import com.haulmont.testtask.model.CreditProposal;
import java.math.BigDecimal;
import java.util.UUID;
import static com.haulmont.testtask.testdata.CreditTestData.*;
import static com.haulmont.testtask.testdata.CustomerTestData.*;

public class CreditProposalTestData {
    public static final TestMatcher<CreditProposal> CREDIT_PROPOSAL_MATCHER = TestMatcher.usingIgnoringFieldsComparator(CreditProposal.class, "payments");

    public static final UUID CREDIT_PROPOSAL1_ID = UUID.fromString("10a069b7-d7b8-4688-a823-504da911e05e");
    public static final UUID CREDIT_PROPOSAL2_ID = UUID.fromString("83918b97-5172-433b-ae6e-047571002730");
    public static final UUID CREDIT_PROPOSAL3_ID = UUID.fromString("f98a967a-00e4-4632-b776-bd66d75cea70");

    public static final CreditProposal CREDIT_PROPOSAL1 = new CreditProposal(CREDIT_PROPOSAL1_ID, new BigDecimal("50.5"), CUSTOMER1, CREDIT1, null);
    public static final CreditProposal CREDIT_PROPOSAL2 = new CreditProposal(CREDIT_PROPOSAL2_ID, new BigDecimal("150.5"), CUSTOMER2, CREDIT2, null);
    public static final CreditProposal CREDIT_PROPOSAL3 = new CreditProposal(CREDIT_PROPOSAL3_ID, new BigDecimal("250.5"), CUSTOMER3, CREDIT3, null);

//    public static final CreditProposal CREDIT_PROPOSAL1 = new CreditProposal(CREDIT_PROPOSAL1_ID, new BigDecimal("50.5"), null, null, null);
//    public static final CreditProposal CREDIT_PROPOSAL2 = new CreditProposal(CREDIT_PROPOSAL2_ID, new BigDecimal("150.5"), null, null, null);
//    public static final CreditProposal CREDIT_PROPOSAL3 = new CreditProposal(CREDIT_PROPOSAL3_ID, new BigDecimal("250.5"), null, null, null);

    public static CreditProposal getNew() {
        return new CreditProposal(null, new BigDecimal("350.5"), CUSTOMER1, CREDIT2, null);
//        return new CreditProposal(null, new BigDecimal("350.5"), null, null, null);
    }

    public static CreditProposal getUpdated() {
        CreditProposal updated = new CreditProposal(CREDIT_PROPOSAL1);
        updated.setCreditAmount(new BigDecimal("450.5"));
        updated.setCustomer(CUSTOMER2);
        updated.setCredit(CREDIT3);
        return updated;
    }
}
