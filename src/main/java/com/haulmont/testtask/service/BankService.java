package com.haulmont.testtask.service;

import com.haulmont.testtask.dao.BankDAO;
import com.haulmont.testtask.model.Bank;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import java.util.UUID;
import static com.haulmont.testtask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class BankService {
    private final BankDAO dao;

    public BankService(BankDAO dao) {
        this.dao = dao;
    }

    public Bank create(Bank bank) {
        Assert.notNull(bank, "bank must not be null");
        return dao.save(bank);
    }

    public void delete(UUID id) {
        checkNotFoundWithId(dao.delete(id), id);
    }

    public Bank get(UUID id) {
        return checkNotFoundWithId(dao.get(id), id);
    }

    public List<Bank> getAll() {
        return dao.getAll();
    }

    public void update(Bank bank) {
        Assert.notNull(bank, "bank must not be null");
        checkNotFoundWithId(dao.save(bank), bank.getId());
    }
}
