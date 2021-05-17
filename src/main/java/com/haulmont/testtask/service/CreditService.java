package com.haulmont.testtask.service;

import com.haulmont.testtask.dao.CreditDAO;
import com.haulmont.testtask.model.Credit;
import java.util.List;
import java.util.UUID;

public class CreditService {
    private final CreditDAO dao;

    public CreditService(CreditDAO dao) {
        this.dao = dao;
    }

    public Credit create(Credit credit) {
        return dao.save(credit);
    }

    public void delete(UUID id) {
        dao.delete(id);
    }

    public Credit get(UUID id) {
        return dao.get(id);
    }

    public List<Credit> getAll() {
        return dao.getAll();
    }

    public void update(Credit credit) {
        dao.save(credit);
    }
}
