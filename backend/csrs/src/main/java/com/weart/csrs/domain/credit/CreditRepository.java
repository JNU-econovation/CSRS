package com.weart.csrs.domain.credit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    @Query("SELECT a FROM Credit a where a.member.id = :memberidValue ")
    List<Credit> findByMemberId(@Param("memberidValue") Long memberId);
}
