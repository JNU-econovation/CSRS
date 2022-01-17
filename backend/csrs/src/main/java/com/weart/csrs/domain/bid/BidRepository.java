package com.weart.csrs.domain.bid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BidRepository extends JpaRepository<Bid, Long> {
    @Query("SELECT max(b.bidPrice) FROM Bid b where b.art.id = :artId ")
    Long findMaxBidPrice(@Param("artId") Long artId);
}
