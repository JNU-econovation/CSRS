package com.weart.csrs.domain.credit;
import com.weart.csrs.domain.member.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    @Query("SELECT a FROM Member a where a.email = :emailValue ")
    List<Member> findByEmail(@Param("emailValue") String emailValue);
}
