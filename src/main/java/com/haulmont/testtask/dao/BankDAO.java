package com.haulmont.testtask.dao;

import com.haulmont.testtask.model.Bank;
import java.util.List;
import java.util.UUID;

public interface BankDAO {
    Bank save(Bank bank);

    boolean delete(UUID id);

    Bank get(UUID id);

    List<Bank> getAll();
}
