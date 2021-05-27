package com.haulmont.testtask.dao;

import com.haulmont.testtask.model.CreditProposal;
import java.util.List;
import java.util.UUID;

public interface CreditProposalDAO {
    CreditProposal save(CreditProposal creditProposal);

    boolean delete(UUID id);

    CreditProposal get(UUID id);

    List<CreditProposal> getAll();
}
