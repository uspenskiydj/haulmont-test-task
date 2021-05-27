package com.haulmont.testtask.service;

import com.haulmont.testtask.dao.CustomerDAO;
import com.haulmont.testtask.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import java.util.UUID;
import static com.haulmont.testtask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class CustomerService {
    private final CustomerDAO dao;

    public CustomerService(CustomerDAO dao) {
        this.dao = dao;
    }

    public Customer create(Customer customer) {
        Assert.notNull(customer, "customer must not be null");
        return dao.save(customer);
    }

    public void delete(UUID id) {
        checkNotFoundWithId(dao.delete(id), id);
    }

    public Customer get(UUID id) {
        return checkNotFoundWithId(dao.get(id), id);
    }

    public List<Customer> getAll() {
        return dao.getAll();
    }

    public void update(Customer customer) {
        Assert.notNull(customer, "customer must not be null");
        checkNotFoundWithId(dao.save(customer), customer.getId());
    }
}
