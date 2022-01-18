package com.weart.csrs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @PostMapping("api/credit/{creditId}")
    public Long createBid(@PathVariable Long memberId, @RequestBody Credit credit) {
        return creditService.createCredit(memberId, credit);
    }

    @GetMapping("api/credit/{creditId}/bid")
    public Long selectBidCount(@PathVariable Long artId) {
        return creditService.selectBidCount(artId);
    }

    @GetMapping("api/credit/{artId}/bids")
    public List<BidResponseDto> selectArtBid(@PathVariable Long artId) {
        return creditService.selectBidList(artId);
    }
}