package com.haulmont.testtask.dao;

import com.haulmont.testtask.model.Payment;
import java.util.List;
import java.util.UUID;

public interface PaymentDAO {
    Payment save(Payment payment);

    boolean delete(UUID id);

    Payment get(UUID id);

    List<Payment> getAll();
}
