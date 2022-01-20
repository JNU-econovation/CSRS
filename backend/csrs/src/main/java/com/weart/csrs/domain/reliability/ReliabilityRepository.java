package com.weart.csrs.domain.reliability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReliabilityRepository extends JpaRepository<Reliability, Long> {

    Optional<Reliability> findById(Long id);

    Reliability save(Reliability reliability);

    Optional<Reliability> findByMemberId(Long memberid);
}
