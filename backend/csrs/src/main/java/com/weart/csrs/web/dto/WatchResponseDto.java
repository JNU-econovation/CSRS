package com.weart.csrs.web.dto;

import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.watchlist.WatchList;

import java.util.Date;

public class WatchResponseDto {
    private Art art;
    private Date addedDate;
    private boolean alarmFlag;

//    public WatchList toWatchList() {
//        return WatchList.builder()
//                .art(art)
//                .member(member)
//                .addedDate(addedDate)
//                .alarmFlag(alarmFlag)
//                .build();
//    }

    public WatchResponseDto(WatchList watchList) {
        this.art = watchList.getArt();
        this.alarmFlag = watchList.getAlarmFlag();
    }
}
