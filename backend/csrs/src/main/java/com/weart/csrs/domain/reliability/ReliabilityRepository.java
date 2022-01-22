package com.weart.csrs.domain.reliability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReliabilityRepository extends JpaRepository<Reliability, Long> {

    Optional<Reliability> findById(Long id);

    List<Reliability> findBySuccessfulBid(String successfulBid);

    List<Reliability> findByWarningScore(String warningScore);

    Reliability save(Reliability reliability);

    Optional<Reliability> findByMemberId(Long memberid);
}