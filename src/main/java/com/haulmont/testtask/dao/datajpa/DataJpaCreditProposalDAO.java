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
    private final CrudCustomerDAO customerDAO;
    private final CrudCreditDAO creditDAO;

    public DataJpaCreditProposalDAO(CrudCreditProposalDAO creditProposalDAO, CrudCustomerDAO customerDAO, CrudCreditDAO creditDAO) {
        this.creditProposalDAO = creditProposalDAO;
        this.customerDAO = customerDAO;
        this.creditDAO = creditDAO;
    }

    @Override
    @Transactional
    public CreditProposal save(CreditProposal creditProposal, UUID customerId, UUID creditId) {
        creditProposal.setCustomer(customerDAO.getOne(customerId));
        creditProposal.setCredit(creditDAO.getOne(creditId));
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
        return creditProposalDAO.findAll();
    }
}
