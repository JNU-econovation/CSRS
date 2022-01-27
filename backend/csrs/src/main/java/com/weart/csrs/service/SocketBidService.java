package com.weart.csrs.service;

import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.art.ArtRepository;
import com.weart.csrs.domain.bid.Bid;
import com.weart.csrs.domain.bid.BidRepository;
import com.weart.csrs.web.dto.ArtResponseDto;
import com.weart.csrs.web.dto.BidCreateRequestDto;
import com.weart.csrs.web.dto.BidResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SocketBidService {
    private final ArtRepository artRepository;
    private final BidRepository bidRepository;

    @Transactional
    public List<BidResponseDto> enter(Long id, BidCreateRequestDto bidCreateRequestDto) {
        Art art = artRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found ART"));

        Pageable pageable = null;
        Bid bid = bidRepository.save(bidCreateRequestDto.toBid(art, bidCreateRequestDto.getBidPrice()));
        List<Bid> bidByArtId = bidRepository.findBidByArtId(art.getId(), pageable);
        return bidByArtId.stream().map(BidResponseDto::new).collect(Collectors.toList());
    }
}
