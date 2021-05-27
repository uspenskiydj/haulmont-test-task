package com.haulmont.testtask.dao.datajpa;

import com.haulmont.testtask.dao.BankDAO;
import com.haulmont.testtask.model.Bank;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class DataJpaBankDAO implements BankDAO {
    private final CrudBankDAO bankDAO;

    public DataJpaBankDAO(CrudBankDAO bankDAO) {
        this.bankDAO = bankDAO;
    }

    @Override
    @Transactional
    public Bank save(Bank bank) {
        return bankDAO.save(bank);
    }

    @Override
    public boolean delete(UUID id) {
        return bankDAO.delete(id) != 0;
    }

    @Override
    public Bank get(UUID id) {
        return bankDAO.findById(id).orElse(null);
    }

    @Override
    public List<Bank> getAll() {
        return bankDAO.findAll();
    }
}
