package com.weart.csrs.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select u from Member as u where u.username=:usernameValue and u.password=:passwordValue")
    List<Member> selectMember(@Param("usernameValue")String usernameValue, @Param("passwordValue")String passwordValue);
}