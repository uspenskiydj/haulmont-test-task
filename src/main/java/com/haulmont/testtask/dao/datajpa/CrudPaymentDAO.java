package com.haulmont.testtask.dao.datajpa;

import com.haulmont.testtask.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional(readOnly = true)
public interface CrudPaymentDAO extends JpaRepository<Payment, UUID> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Payment p WHERE p.id=:id AND p.creditProposal.id =:creditProposalId")
    int delete(@Param("id") UUID id, @Param("creditProposalId") UUID creditProposalId);

    @Query("SELECT p FROM Payment p WHERE p.creditProposal.id=:creditProposalId")
    List<Payment> getAll(@Param("creditProposalId") UUID creditProposalId);
}
