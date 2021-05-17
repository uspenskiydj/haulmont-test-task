package com.haulmont.testtask.dao.inmemory;

import com.haulmont.testtask.dao.CreditDAO;
import com.haulmont.testtask.model.Credit;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCreditDAO implements CreditDAO {
    private final Map<UUID, Credit> db = new ConcurrentHashMap<>();

    {
        db.put(UUID.randomUUID(), new Credit(new BigDecimal("200.5"), "9"));
        db.put(UUID.randomUUID(), new Credit(new BigDecimal("100.5"), "10"));
        db.put(UUID.randomUUID(), new Credit(new BigDecimal("300.5"), "11"));
    }

    @Override
    public Credit save(Credit credit) {
        if (credit.getId() == null) {
            credit.setId(UUID.randomUUID());
            db.put(credit.getId(), credit);
            return credit;
        }
        return db.computeIfPresent(credit.getId(), (id, oldCredit) -> credit);
    }

    @Override
    public boolean delete(UUID id) {
        return db.remove(id) != null;
    }

    @Override
    public Credit get(UUID id) {
        return db.get(id);
    }

    @Override
    public List<Credit> getAll() {
        ArrayList<Credit> credits = new ArrayList<>(db.values());
        credits.sort(Comparator.comparing(Credit::getLimit));
        return credits;
    }
}
