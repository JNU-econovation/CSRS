package com.weart.csrs.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select u from Member u where u.id=:id and u.password=:password")
    Member selectMember(@Param("id")String id, @Param("password")String password);
}
