package com.haulmont.testtask.dao;

import com.haulmont.testtask.model.Payment;
import java.util.List;
import java.util.UUID;

public interface PaymentDAO {
    Payment save(Payment payment, UUID creditProposalId);

    boolean delete(UUID id, UUID creditProposalId);

    Payment get(UUID id, UUID creditProposalId);

    List<Payment> getAll(UUID creditProposalId);
}
