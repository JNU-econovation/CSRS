//package com.weart.csrs.service;
//
//import com.weart.csrs.domain.art.Art;
//import com.weart.csrs.domain.art.ArtRepository;
//import com.weart.csrs.domain.member.Member;
//import com.weart.csrs.domain.member.MemberRepository;
//import com.weart.csrs.domain.watchlist.WatchList;
//import com.weart.csrs.domain.watchlist.WatchListRepository;
//import com.weart.csrs.web.dto.WatchResponseDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static com.weart.csrs.web.dto.WatchListRequestDto.toWatchList;
//
//@Service
//@RequiredArgsConstructor
//public class WatchListService {
//    private static final String NOT_FOUND_ART_MESSAGE = "해당 장바구니 목록을 찾을 수 없습니다.";
//    private final WatchListRepository watchListRepository;
//    private final ArtRepository artRepository;
//    private final MemberRepository memberRepository;
//
//    @Transactional
//    public Long createWatchList(Long artId, Long memberId){
//        Art art = artRepository.findById(artId).orElseThrow(() -> new IllegalArgumentException("There's No Art"));
//        System.out.println(art);
//        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("There's No Member"));
//        WatchList watchList = watchListRepository.save(toWatchList(art, member));
//        return watchList.getId();
//    }
//
//    //장바구니 삭제 기능
//    @Transactional
//    public Long deleteWatchList(Long watchlistId){
//        WatchList watchList = watchListRepository.findById(watchlistId)
//                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
//        watchListRepository.delete(watchList);
//        return watchList.getId();
//    }
//
////    @Transactional
////    public WatchResponseDto selectWatchListByMemberId(Long memberId){
////        WatchList memberWatchList = watchListRepository.findById(memberId)
////                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
////        return new WatchResponseDto(memberWatchList);
////    }
//    @Transactional
//    public List<WatchResponseDto> selectAll(){
//        return watchListRepository.findAll().stream()
//                .map(WatchResponseDto::new)
//                .collect(Collectors.toList());
//    }
//
//    @Transactional
//    public List<WatchList> findByMemberId(Long memberId){
//        return watchListRepository.findByMemberId(memberId);
//    }
//    @Transactional
//    public Long selectWatchListById(Long watchlistId){
//        WatchList watchList = watchListRepository.getById(watchlistId);
//        return watchList.getId();
//    }
//
//
//}
//
