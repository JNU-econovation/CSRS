package com.weart.csrs.web.controller;

import com.weart.csrs.service.BidService;
import com.weart.csrs.web.dto.BidCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BidController {
    private final BidService bidService;

    @PostMapping("api/arts/{artId}/bid")
    public Long createBid(@PathVariable Long artId, @RequestBody BidCreateRequestDto bidCreateRequestDto) {
        return bidService.createBid(artId, bidCreateRequestDto);
    }
}
