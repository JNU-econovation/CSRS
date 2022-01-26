package com.weart.csrs.web.dto;


import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.watchlist.WatchList;

public class WatchListRequestDto {
    private Art art;
    private Member member;

    public static WatchList toWatchList(Art art, Member member) {
        return WatchList.builder()
                .art(art)
                .member(member)
                .build();
    }
}