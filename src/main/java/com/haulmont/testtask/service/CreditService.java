package com.haulmont.testtask.service;

import com.haulmont.testtask.dao.CreditDAO;
import com.haulmont.testtask.model.Credit;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import java.util.UUID;
import static com.haulmont.testtask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class CreditService {
    private final CreditDAO dao;

    public CreditService(CreditDAO dao) {
        this.dao = dao;
    }

    public Credit create(Credit credit) {
        Assert.notNull(credit, "credit must not be null");
        return dao.save(credit);
    }

    public void delete(UUID id) {
        checkNotFoundWithId(dao.delete(id), id);
    }

    public Credit get(UUID id) {
        return checkNotFoundWithId(dao.get(id), id);
    }

    public List<Credit> getAll() {
        return dao.getAll();
    }

    public void update(Credit credit) {
        Assert.notNull(credit, "credit must not be null");
        checkNotFoundWithId(dao.save(credit), credit.getId());
    }
}
