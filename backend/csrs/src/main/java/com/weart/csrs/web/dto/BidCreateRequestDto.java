package com.weart.csrs.web.dto;

import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.bid.Bid;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BidCreateRequestDto {
    private Long bidPrice;

    public BidCreateRequestDto(Long bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Bid toBid(Art art, Long bidPrice) {
        return Bid.builder()
                .art(art)
                .bidPrice(bidPrice)
                .build();
    }
}
