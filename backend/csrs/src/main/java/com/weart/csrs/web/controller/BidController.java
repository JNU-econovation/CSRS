package com.weart.csrs.web.controller;

import com.weart.csrs.domain.bid.Bid;
import com.weart.csrs.service.BidService;
import com.weart.csrs.web.dto.BidCreateRequestDto;
import com.weart.csrs.web.dto.BidResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BidController {
    private final BidService bidService;

    @PostMapping("api/arts/{artId}/bid")
    public Long createBid(@PathVariable Long artId, @RequestBody BidCreateRequestDto bidCreateRequestDto) {
        return bidService.createBid(artId, bidCreateRequestDto);
    }

    @GetMapping("api/arts/{artId}/bid")
    public Long selectBidCount(@PathVariable Long artId) {
        return bidService.selectBidCount(artId);
    }

    @GetMapping("api/arts/{artId}/bids")
    public List<BidResponseDto> selectArtBid(@PathVariable Long artId) {
        return bidService.selectBidList(artId);
    }
}
