package com.weart.csrs.web.controller;

import com.weart.csrs.service.BidService;
import com.weart.csrs.service.SocketBidService;
import com.weart.csrs.web.dto.BidCreateRequestDto;
import com.weart.csrs.web.dto.BidResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/arts")
public class SocketBidController {
    private final SocketBidService socketBidService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping(path = "{id}/auctions/enter")
    public List<BidResponseDto> enter(
            @PathVariable Long id,
            @RequestBody BidCreateRequestDto requestDto) {


        // 시간 채
        // isFinish Check


        List<BidResponseDto> result = socketBidService.enter(id, requestDto);
        // 새로운 경매요소 반환


        // 상품에 대한 auction 전체 정보 반환?
        simpMessagingTemplate.convertAndSend("/topic/bid", result);
        return result;
    }
}
