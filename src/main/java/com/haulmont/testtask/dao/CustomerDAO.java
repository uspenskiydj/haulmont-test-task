package com.haulmont.testtask.dao;

import com.haulmont.testtask.model.Customer;
import java.util.List;
import java.util.UUID;

public interface CustomerDAO {
    Customer save(Customer customer);

    boolean delete(UUID id);

    Customer get(UUID id);

    List<Customer> getAll();

    List<Customer> getAllByBank(UUID bankID);
}
