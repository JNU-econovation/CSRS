package com.weart.csrs.web.dto;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.watchlist.WatchList;

import java.util.Date;

public class WatchResponseDto {
    private Art art;
    private Member member;
    private Date addedDate;
    private boolean alarmFlag;


    public WatchResponseDto(WatchList watchList) {
        this.art = watchList.getArt();
        this.member = watchList.getMember();
        this.addedDate = watchList.getAddedDate();
        this.alarmFlag = watchList.getAlarmFlag();
    }
}
