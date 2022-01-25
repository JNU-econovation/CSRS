package com.weart.csrs.web.dto;


import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.watchlist.WatchList;

public class WatchListRequestDto {
    private Art art;

    public static WatchList toWatchList(Art art) {
        return WatchList.builder()
                .art(art)
                .build();
    }
}