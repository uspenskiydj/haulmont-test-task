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
        UUID uuid1 = UUID.randomUUID();
        Customer customer1 = new Customer("FIO1", "tel1", "email1", "pas1");
        customer1.setId(uuid1);
        db.put(uuid1, customer1);

        UUID uuid2 = UUID.randomUUID();
        Customer customer2 = new Customer("FIO2", "tel2", "email2", "pas2");
        customer2.setId(uuid2);
        db.put(uuid2, customer2);

        UUID uuid3 = UUID.randomUUID();
        Customer customer3 = new Customer("FIO3", "tel3", "email3", "pas3");
        customer3.setId(uuid3);
        db.put(uuid3, customer3);
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
