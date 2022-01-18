package com.weart.csrs.web.dto.controller;

import com.weart.csrs.service.WatchListService;
import com.weart.csrs.web.dto.WatchListRequestDto;
import com.weart.csrs.web.dto.WatchResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@ComponentScan({"com.weart.csrs.service.WatchListService"})
@Controller
public class WatchListController {

    private final WatchListService watchListService;


    //생성자에 DI (의존성 주입)
    @Autowired
    public WatchListController(WatchListService watchListService) {
        this.watchListService = watchListService;
    }

    //장바구니에 추가하기 (

    @PostMapping("api/watchlist/{id}")
    public Long watchListCreate(@RequestBody WatchListRequestDto watchListRequestDto) {
        return watchListService.createWathcList(watchListRequestDto);
    }


    @GetMapping("api/watchlist/{memberId}")
    public WatchResponseDto selectWatchListByMemberId(@PathVariable Long memberId) {
        return watchListService.selectWatchListByMemberId(memberId);
    }

    @GetMapping("api/watchlist/list")
    public List<WatchResponseDto> selectAllWatchList() {
        return watchListService.selectAll();
    }

    @PutMapping("api/watchlist/{watchlistId}")
    public Long watchListUpdate(@PathVariable Long watchlistId, @RequestBody WatchListRequestDto watchListRequestDto) {
        return watchListService.updateWatchList(watchlistId, watchListRequestDto);
    }

    @DeleteMapping("api/watchlist/{watchlistId}")
    public Long deleteWatchList(@PathVariable Long watchlistId) {
        watchListService.deleteWatchList(watchlistId);
        return watchlistId;
    }
}