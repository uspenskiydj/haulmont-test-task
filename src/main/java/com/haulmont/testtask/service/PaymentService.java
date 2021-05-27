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

    public Payment create(Payment payment) {
        Assert.notNull(payment, "payment must not be null");
        return dao.save(payment);
    }

    public void delete(UUID id) {
        checkNotFoundWithId(dao.delete(id), id);
    }

    public Payment get(UUID id) {
        return checkNotFoundWithId(dao.get(id), id);
    }

    public List<Payment> getAll() {
        return dao.getAll();
    }

    public void update(Payment payment) {
        Assert.notNull(payment, "payment must not be null");
        dao.save(payment);
    }
}
