package com.haulmont.testtask.service;

import com.haulmont.testtask.dao.CreditProposalDAO;
import com.haulmont.testtask.model.CreditProposal;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import java.util.UUID;
import static com.haulmont.testtask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class CreditProposalService {
    private final CreditProposalDAO dao;

    public CreditProposalService(CreditProposalDAO dao) {
        this.dao = dao;
    }

    public CreditProposal create(CreditProposal creditProposal) {
        Assert.notNull(creditProposal, "creditProposal must not be null");
        return dao.save(creditProposal);
    }

    public void delete(UUID id) {
        checkNotFoundWithId(dao.delete(id), id);
    }

    public CreditProposal get(UUID id) {
        return checkNotFoundWithId(dao.get(id), id);
    }

    public List<CreditProposal> getAll() {
        return dao.getAll();
    }

    public void update(CreditProposal creditProposal) {
        Assert.notNull(creditProposal, "creditProposal must not be null");
        dao.save(creditProposal);
    }
}
