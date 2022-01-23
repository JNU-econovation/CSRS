package com.weart.csrs.domain.member;

import com.weart.csrs.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);

    Optional<Member> findByEmail(String email);
}
