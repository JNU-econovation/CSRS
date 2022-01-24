package com.weart.csrs.domain.bid;


import com.weart.csrs.domain.bid.Bid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    @Query("SELECT max(b.bidPrice) FROM Bid b where b.art.id = :artId ")
    Long findMaxBidPrice(@Param("artId") Long artId);

    @Query("SELECT COUNT(b) FROM Bid b where b.art.id = :artId")
    Long findCountBidMember(@Param("artId") Long artId);

    @Query("SELECT b FROM Bid b where b.art.id = :artId order by b.bidPrice desc")
    List<Bid> findBidByArtId(@Param("artId") Long artId, Pageable pageable);

//    @Query("SELECT b from Bid b where b.bidPrice = :bidPrice")
//    Bid findBidByBidPrice(@Param("bidPrice") Long bidPrice);
}
