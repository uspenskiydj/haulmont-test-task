package com.haulmont.testtask.service;

import com.haulmont.testtask.dao.BankDAO;
import com.haulmont.testtask.model.Bank;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class BankService {
    private final BankDAO dao;

    public BankService(BankDAO dao) {
        this.dao = dao;
    }

    public Bank create(Bank bank) {
        return dao.save(bank);
    }

    public void delete(UUID id) {
        dao.delete(id);
    }

    public Bank get(UUID id) {
        return dao.get(id);
    }

    public List<Bank> getAll() {
        return dao.getAll();
    }

    public void update(Bank bank) {
        dao.save(bank);
    }
}
