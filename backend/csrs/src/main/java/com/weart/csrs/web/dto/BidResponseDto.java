package com.weart.csrs.web.dto;

import com.weart.csrs.domain.bid.Bid;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BidResponseDto {
    private LocalDateTime createdDate;
    private Long bidPrice;

    public BidResponseDto(Bid bid) {
        createdDate = bid.getCreatedDate();
        bidPrice = bid.getBidPrice();
    }
}
