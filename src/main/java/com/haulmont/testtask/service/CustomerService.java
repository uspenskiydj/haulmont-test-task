package com.haulmont.testtask.service;

import com.haulmont.testtask.dao.CustomerDAO;
import com.haulmont.testtask.model.Customer;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerDAO dao;

    public CustomerService(CustomerDAO dao) {
        this.dao = dao;
    }

    public Customer create(Customer customer) {
        return dao.save(customer);
    }

    public void delete(UUID id) {
        dao.delete(id);
    }

    public Customer get(UUID id) {
        return dao.get(id);
    }

    public List<Customer> getAll() {
        return dao.getAll();
    }

    public void update(Customer customer) {
        dao.save(customer);
    }
}
