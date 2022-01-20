package com.weart.csrs.web.dto.controller;

import com.weart.csrs.service.WatchListService;
import com.weart.csrs.web.dto.WatchResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WatchListController {

    private final WatchListService watchListService;


    //장바구니에 추가하기 (
    @PostMapping("api/watchlist/{artId}")
    public Long saveWatchList(@PathVariable Long artId) {
        return watchListService.createWatchList(artId);
    }


    @GetMapping("api/watchlist/{watchlistId}")
    public Long selectWatchListById(@PathVariable Long watchlistId) {
        return watchListService.selectWatchListById(watchlistId);
    }

    @GetMapping("api/watchlist/list")
    public List<WatchResponseDto> selectAllWatchList() {
        return watchListService.selectAll();
    }


    @DeleteMapping("api/watchlist/{watchlistId}")
    public Long deleteWatchList(@PathVariable Long watchlistId) {
        watchListService.deleteWatchList(watchlistId);
        return watchlistId;
    }
}