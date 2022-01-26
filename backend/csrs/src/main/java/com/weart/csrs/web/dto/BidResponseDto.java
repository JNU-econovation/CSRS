package com.weart.csrs.web.dto;

import com.weart.csrs.domain.bid.Bid;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.weart.csrs.util.StringUtils.expressPrice;

@Getter
public class BidResponseDto {
    private LocalDateTime createdDate;
    private String bidPrice;

    public BidResponseDto(Bid bid) {
        createdDate = bid.getCreatedDate();
        bidPrice = expressPrice(bid.getBidPrice());
    }
}
