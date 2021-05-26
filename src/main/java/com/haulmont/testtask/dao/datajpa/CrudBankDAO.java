package com.haulmont.testtask.dao.datajpa;

import com.haulmont.testtask.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Transactional(readOnly = true)
public interface CrudBankDAO extends JpaRepository<Bank, UUID> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Bank b WHERE b.id=:id")
    int delete(@Param("id") UUID id);

}
