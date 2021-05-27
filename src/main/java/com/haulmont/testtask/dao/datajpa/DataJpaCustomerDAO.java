package com.haulmont.testtask.dao.datajpa;

import com.haulmont.testtask.dao.CustomerDAO;
import com.haulmont.testtask.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class DataJpaCustomerDAO implements CustomerDAO {
    private final CrudCustomerDAO customerDAO;

    public DataJpaCustomerDAO(CrudCustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public boolean delete(UUID id) {
        return customerDAO.delete(id) != 0;
    }

    @Override
    public Customer get(UUID id) {
        return customerDAO.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getAll() {
        return customerDAO.findAll();
    }
}
