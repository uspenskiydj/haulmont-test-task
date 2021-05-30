package com.haulmont.testtask.dao.datajpa;

import com.haulmont.testtask.model.Credit;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudCreditDAO extends JpaRepository<Credit, UUID> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Credit c WHERE c.id=:id")
    int delete(@Param("id") UUID id);

    @Query("SELECT c FROM Credit c WHERE c.bank.id=:bankId")
    List<Credit> getAll(@Param("bankId") UUID bankId);
}
