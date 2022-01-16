package com.weart.csrs.service;

import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.art.ArtRepository;
import com.weart.csrs.domain.bid.Bid;
import com.weart.csrs.domain.bid.BidRepository;
import com.weart.csrs.web.dto.BidCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BidService {
    private final BidRepository bidRepository;
    private final ArtRepository artRepository;
    private static final String NOT_FOUND_ART_MESSAGE = "해당 예술품을 찾을 수 없습니다.";

    @Transactional
    public Long createBid(Long artId, BidCreateRequestDto bidCreateRequestDto) {
        Art art = artRepository.findById(artId).orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        Bid bid = bidRepository.save(bidCreateRequestDto.toBid(art, bidCreateRequestDto.getBidPrice()));
        return bid.getId();
    }
}
