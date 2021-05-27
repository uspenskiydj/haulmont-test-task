package com.haulmont.testtask.dao.datajpa;

import com.haulmont.testtask.dao.CreditProposalDAO;
import com.haulmont.testtask.model.CreditProposal;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class DataJpaCreditProposalDAO implements CreditProposalDAO {
    private final CrudCreditProposalDAO creditProposalDAO;

    public DataJpaCreditProposalDAO(CrudCreditProposalDAO creditProposalDAO) {
        this.creditProposalDAO = creditProposalDAO;
    }

    @Override
    @Transactional
    public CreditProposal save(CreditProposal creditProposal) {
        return creditProposalDAO.save(creditProposal);
    }

    @Override
    public boolean delete(UUID id) {
        return creditProposalDAO.delete(id) != 0;
    }

    @Override
    public CreditProposal get(UUID id) {
        return creditProposalDAO.findById(id).orElse(null);
    }

    @Override
    public List<CreditProposal> getAll() {
//        return creditProposalDAO.findAll();
        return creditProposalDAO.getAll();
    }
}
