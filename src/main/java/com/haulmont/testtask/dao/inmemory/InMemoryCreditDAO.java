package com.haulmont.testtask.dao.inmemory;

import com.haulmont.testtask.dao.CreditDAO;
import com.haulmont.testtask.model.Credit;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryCreditDAO implements CreditDAO {
    private final Map<UUID, Credit> db = new ConcurrentHashMap<>();

    {
        UUID uuid1 = UUID.randomUUID();
        Credit credit1 = new Credit(new BigDecimal("200.5"), "9");
        credit1.setId(uuid1);
        db.put(uuid1, credit1);

        UUID uuid2 = UUID.randomUUID();
        Credit credit2 = new Credit(new BigDecimal("100.5"), "10");
        credit2.setId(uuid2);
        db.put(uuid2, credit2);

        UUID uuid3 = UUID.randomUUID();
        Credit credit3 = new Credit(new BigDecimal("300.5"), "11");
        credit3.setId(uuid3);
        db.put(uuid3, credit3);
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
