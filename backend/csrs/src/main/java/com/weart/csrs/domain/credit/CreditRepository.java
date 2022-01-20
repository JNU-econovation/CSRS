package com.weart.csrs.domain.credit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    @Query("SELECT a FROM Member a where a.id = :memberidValue ")
    Credit findByMemberId(@Param("memberidValue") Long memberId);
}
