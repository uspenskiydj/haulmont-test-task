package com.haulmont.testtask.dao;

import com.haulmont.testtask.model.Credit;
import java.util.List;
import java.util.UUID;

public interface CreditDAO {
    Credit save(Credit credit);

    boolean delete(UUID id);

    Credit get(UUID id);

    List<Credit> getAll();

    List<Credit> getAllByBank(UUID bankID);
}
