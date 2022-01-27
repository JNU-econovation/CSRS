package com.weart.csrs.service;

import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.art.ArtRepository;
import com.weart.csrs.domain.bid.Bid;
import com.weart.csrs.domain.bid.BidRepository;
import com.weart.csrs.util.StringUtils;
import com.weart.csrs.web.dto.BidCreateRequestDto;
import com.weart.csrs.web.dto.BidResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.weart.csrs.util.StringUtils.expressPrice;

@RequiredArgsConstructor
@Service
public class BidService {
    private final BidRepository bidRepository;
    private final ArtRepository artRepository;
    private static final String NOT_FOUND_ART_MESSAGE = "해당 예술품을 찾을 수 없습니다.";
    private static final String INVALIDATE_BID_PRICE = "입찰 가격은 입찰 최고 가격보다 더 높은 가격만 제시할 수 있습니다.";

    @Transactional
    public Long createBid(Long artId, BidCreateRequestDto bidCreateRequestDto) {
        Art art = artRepository.findById(artId).orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        Long maxBidPrice = bidRepository.findMaxBidPrice(artId);
        if (maxBidPrice != null && maxBidPrice >= bidCreateRequestDto.getBidPrice()) {
            throw new IllegalArgumentException(INVALIDATE_BID_PRICE);
        }
        if(art.checkBidEndTime()){
            throw new IllegalArgumentException("입찰할 수 없음");
        }
        Bid bid = bidRepository.save(bidCreateRequestDto.toBid(art, bidCreateRequestDto.getBidPrice()));
        return bid.getId();
    }

    @Transactional
    public Long selectBidCount(Long artId) {
        Art art = artRepository.findById(artId).orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        return bidRepository.findCountBidMember(art.getId());
    }

    @Transactional
    public List<BidResponseDto> selectBidList(Long artId, Pageable pageable) {
        Art art = artRepository.findById(artId).orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        return bidRepository.findBidByArtId(art.getId(), pageable)
                .stream()
                .map(BidResponseDto::new)
                .collect(Collectors.toList());

    }

    @Transactional
    public String selectBidMaxPrice(Long artId) {
        Art art = artRepository.findById(artId).orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        Pageable pageable = null;
        List<BidResponseDto> bidResponseDtos = selectBidList(art.getId(), pageable);
        if (bidResponseDtos.isEmpty()) {
            return "0";
        }
        Long maxBidPrice = bidRepository.findMaxBidPrice(art.getId());
        return expressPrice(maxBidPrice);
    }
}
