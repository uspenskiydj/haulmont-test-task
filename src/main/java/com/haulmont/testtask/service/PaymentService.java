package com.haulmont.testtask.service;

import com.haulmont.testtask.dao.PaymentDAO;
import com.haulmont.testtask.model.Payment;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import java.util.UUID;
import static com.haulmont.testtask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class PaymentService {
    private final PaymentDAO dao;

    public PaymentService(PaymentDAO dao) {
        this.dao = dao;
    }

    public Payment create(Payment payment, UUID creditProposalId) {
        Assert.notNull(payment, "payment must not be null");
        return dao.save(payment, creditProposalId);
    }

    public void delete(UUID id, UUID creditProposalId) {
        checkNotFoundWithId(dao.delete(id, creditProposalId), id);
    }

    public Payment get(UUID id, UUID creditProposalId) {
        return checkNotFoundWithId(dao.get(id, creditProposalId), id);
    }

    public List<Payment> getAll(UUID creditProposalId) {
        return dao.getAll(creditProposalId);
    }

    public void update(Payment payment, UUID creditProposalId) {
        Assert.notNull(payment, "payment must not be null");
        checkNotFoundWithId(dao.save(payment, creditProposalId), payment.getId());
    }
}
