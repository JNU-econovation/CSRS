package com.weart.csrs.Repository;

import com.weart.csrs.domain.MEMBER.MEMBER;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MEMBERRepository extends JpaRepository<MEMBER, Long> {
    Optional<MEMBER> findByName(String name);
}
