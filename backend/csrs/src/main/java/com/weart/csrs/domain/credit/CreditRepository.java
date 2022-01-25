package com.weart.csrs.domain.credit;
import com.weart.csrs.domain.member.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    @Query("SELECT a FROM Member a where a.id = :memberidValue ")
    Credit findByMemberId(@Param("memberidValue") Long memberId);
}
