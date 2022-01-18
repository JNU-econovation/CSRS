package com.weart.csrs.web.dto;


import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.watchlist.WatchList;
import lombok.Builder;

import java.util.Date;

public class WatchListRequestDto {
    private Art art;
    private Member member;
    private Date addedDate;
    private boolean alarmFlag;

    @Builder
    public WatchListRequestDto(Art art,Member member, Date addedDate, boolean alarmFlag) {
        this.art = art;
        this.member = member;
        this.addedDate = addedDate;
        this.alarmFlag = alarmFlag;
    }


    public WatchList toWatchList() {
        return WatchList.builder()
                .art(art)
                .member(member)
                .addedDate(addedDate)
                .alarmFlag(alarmFlag)
                .build();
    }
}