package com.haulmont.testtask.dao.datajpa;

import com.haulmont.testtask.dao.PaymentDAO;
import com.haulmont.testtask.model.Payment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public class DataJpaPaymentDAO implements PaymentDAO {
    private final CrudPaymentDAO paymentDAO;
    private final CrudCreditProposalDAO creditProposalDAO;

    public DataJpaPaymentDAO(CrudPaymentDAO paymentDAO, CrudCreditProposalDAO creditProposalDAO) {
        this.paymentDAO = paymentDAO;
        this.creditProposalDAO = creditProposalDAO;
    }

    @Override
    @Transactional
    public Payment save(Payment payment, UUID creditProposalId) {
        payment.setCreditProposal(creditProposalDAO.getOne(creditProposalId));
        return paymentDAO.save(payment);
    }

    @Override
    public boolean delete(UUID id, UUID creditProposalId) {
        return paymentDAO.delete(id, creditProposalId) != 0;
    }

    @Override
    public Payment get(UUID id, UUID creditProposalId) {
        return paymentDAO.findById(id)
                .filter(payment -> payment.getCreditProposal().getId().equals(creditProposalId))
                .orElse(null);
    }

    @Override
    public List<Payment> getAll(UUID creditProposalId) {
        return paymentDAO.getAll(creditProposalId);
    }
}
