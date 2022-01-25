package com.weart.csrs.service;

import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.art.ArtRepository;
import com.weart.csrs.domain.watchlist.WatchList;
import com.weart.csrs.domain.watchlist.WatchListRepository;
import com.weart.csrs.web.dto.WatchResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.weart.csrs.web.dto.WatchListRequestDto.toWatchList;

@Service
@RequiredArgsConstructor
public class WatchListService {
    private static final String NOT_FOUND_ART_MESSAGE = "해당 장바구니 목록을 찾을 수 없습니다.";
    private final WatchListRepository watchListRepository;
    private final ArtRepository artRepository;
    
    @Transactional
    public Long createWatchList(Long artId){
        Art art = artRepository.findById(artId).orElseThrow(() -> new IllegalArgumentException("There's No Art"));
        System.out.println(art);
        WatchList watchList = watchListRepository.save(toWatchList(art));
        return art.getId();
    }
//    @Transactional
//    public WatchResponseDto selectWatchListByMemberId(Long memberId){
//        WatchList memberWatchList = watchListRepository.findById(memberId)
//                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
//        return new WatchResponseDto(memberWatchList);
//    }
//    @Transactional
//    public List<WatchResponseDto> selectAll(){
//        return watchListRepository.findAll().stream()
//                .map(WatchList::new)
//                .collect(Collectors.toList());
//    }
    @Transactional
    public Long selectWatchListById(Long watchlistId){
        WatchList watchList = watchListRepository.getById(watchlistId);
        return watchList.getId();
    }

    //장바구니 삭제 기능
    @Transactional
    public Long deleteWatchList(Long watchlistId){
        WatchList watchList = watchListRepository.findById(watchlistId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        watchListRepository.delete(watchList);
        return watchList.getId();
    }
}

