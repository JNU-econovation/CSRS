package com.weart.csrs.domain.watchlist;

import com.weart.csrs.web.dto.WatchResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WatchListRepository extends JpaRepository<WatchList,Long> {
    @Query("SELECT a FROM WatchList a where a.id = :watchListId ")
    Optional<WatchList> findById(@Param("watchListId") Long memberValue);

    @Query("SELECT a FROM WatchList a where a.member = :memberId ")
    List<WatchList> findByMemberId(@Param("memberId") Long memberValue);

    //ResponseDto 데이터 ;
    WatchList save(WatchResponseDto watchResponseDto);
}
