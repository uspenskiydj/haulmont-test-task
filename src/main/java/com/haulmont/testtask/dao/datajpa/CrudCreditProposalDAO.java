package com.haulmont.testtask.dao.datajpa;

import com.haulmont.testtask.model.CreditProposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional(readOnly = true)
public interface CrudCreditProposalDAO extends JpaRepository<CreditProposal, UUID> {
    @Transactional
    @Modifying
    @Query("DELETE FROM CreditProposal c WHERE c.id=:id")
    int delete(@Param("id") UUID id);

    @Query("SELECT c FROM CreditProposal c")
    List<CreditProposal> getAll();
}
