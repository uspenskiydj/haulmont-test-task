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

    public DataJpaPaymentDAO(CrudPaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    @Transactional
    public Payment save(Payment payment) {
        return paymentDAO.save(payment);
    }

    @Override
    public boolean delete(UUID id) {
        return paymentDAO.delete(id) != 0;
    }

    @Override
    public Payment get(UUID id) {
        return paymentDAO.findById(id).orElse(null);
    }

    @Override
    public List<Payment> getAll() {
        return paymentDAO.findAll();
    }
}
