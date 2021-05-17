package com.haulmont.testtask.dao.inmemory;

import com.haulmont.testtask.dao.CustomerDAO;
import com.haulmont.testtask.model.Customer;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryCustomerDAO implements CustomerDAO {
    private final Map<UUID, Customer> db = new ConcurrentHashMap<>();

    {
        db.put(UUID.randomUUID(), new Customer("FIO1", "tel1", "email1", "pas1"));
        db.put(UUID.randomUUID(), new Customer("FIO2", "tel2", "email2", "pas2"));
        db.put(UUID.randomUUID(), new Customer("FIO3", "tel3", "email3", "pas3"));
    }

    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(UUID.randomUUID());
            db.put(customer.getId(), customer);
            return customer;
        }
        return db.computeIfPresent(customer.getId(), (id, oldCustomer) -> customer);
    }

    @Override
    public boolean delete(UUID id) {
        return db.remove(id) != null;
    }

    @Override
    public Customer get(UUID id) {
        return db.get(id);
    }

    @Override
    public List<Customer> getAll() {
        ArrayList<Customer> customers = new ArrayList<>(db.values());
        customers.sort(Comparator.comparing(Customer::getFIO));
        return customers;
    }
}
