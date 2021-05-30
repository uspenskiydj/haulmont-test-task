package com.haulmont.testtask.dao.datajpa;

import com.haulmont.testtask.dao.CreditDAO;
import com.haulmont.testtask.model.Credit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class DataJpaCreditDAO implements CreditDAO {
    private final CrudCreditDAO creditDAO;

    public DataJpaCreditDAO(CrudCreditDAO creditDAO) {
        this.creditDAO = creditDAO;
    }

    @Override
    @Transactional
    public Credit save(Credit credit) {
        return creditDAO.save(credit);
    }

    @Override
    public boolean delete(UUID id) {
        return creditDAO.delete(id) != 0;
    }

    @Override
    public Credit get(UUID id) {
        return creditDAO.findById(id).orElse(null);
    }

    @Override
    public List<Credit> getAll() {
        return creditDAO.findAll();
    }

    @Override
    public List<Credit> getAllByBank(UUID bankID) {
        return creditDAO.getAll(bankID);
    }
}
