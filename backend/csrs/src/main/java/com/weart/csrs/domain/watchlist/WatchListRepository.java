package com.weart.csrs.domain.watchlist;

import com.weart.csrs.domain.watchlist.WatchList;
import com.weart.csrs.web.dto.WatchResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WatchListRepository extends JpaRepository<WatchList,Long> {
    @Query("SELECT a FROM WatchList a where a.member = :memberValue ")
    WatchList findByMemberId(@Param("memberValue") Long memberValue);

    //ResponseDto 데이터 ;
    WatchList save(WatchResponseDto watchResponseDto);


}
