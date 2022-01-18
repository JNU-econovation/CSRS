package com.weart.csrs.service;

import com.weart.csrs.domain.watchlist.WatchListRepository;
import com.weart.csrs.domain.watchlist.WatchList;
import com.weart.csrs.web.dto.WatchListRequestDto;
import com.weart.csrs.web.dto.WatchResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WatchListService {
    private static final String NOT_FOUND_ART_MESSAGE = "해당 장바구니 목록을 찾을 수 없습니다.";
    private final WatchListRepository watchListRepository;

    @Autowired
    public WatchListService(WatchListRepository watchListRepository) {
        this.watchListRepository = watchListRepository;
    }

    @Transactional
    public Long createWathcList(WatchListRequestDto watchListRequestDto){
        WatchList watchList = watchListRepository.save(watchListRequestDto.toWatchList());
        return watchList.getId();
    }
    @Transactional
    public WatchResponseDto selectWatchListByMemberId(Long memberId){
        WatchList memberWatchList = watchListRepository.findByMemberId(memberId);
//                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        return new WatchResponseDto(memberWatchList);
    }
    @Transactional
    public List<WatchResponseDto> selectAll(){
        return watchListRepository.findAll().stream()
                .map(WatchResponseDto::new)
                .collect(Collectors.toList());

        // 1시간 뒤의 서현아 힘내
    }

    //장바구니 업데이트
    @Transactional
    public Long updateWatchList(Long watchlistId, WatchListRequestDto watchListRequestDto){
        WatchList watchList = watchListRepository.findById(watchlistId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        watchList.update(watchListRequestDto);
        return watchlistId;
    }

    //장바구니 삭제 기능
    @Transactional
    public Long deleteWatchList(Long watchlistId){
        WatchList watchList = watchListRepository.findById(watchlistId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        watchListRepository.delete(watchList);
        return watchlistId;
    }
}

