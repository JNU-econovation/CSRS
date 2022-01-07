package com.weart.csrs.Repository;

import com.weart.csrs.domain.MEMBER.MEMBER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MEMBERRepository extends JpaRepository<MEMBER, Long> {
    Optional<MEMBER> findByEmail(String email);
}
