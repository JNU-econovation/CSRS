package com.weart.csrs.web.dto;

import com.weart.csrs.domain.art.Art;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArtResponeDto {
    private String title;
    private String content;
    private Long auctionStartPrice;
    private LocalDateTime auctionStartDate;
    private LocalDateTime auctionEndDate;

    public ArtResponeDto(Art art) {
        this.title = art.getTitle();
        this.content = art.getContent();
        this.auctionStartPrice = art.getAuctionStartPrice();
        this.auctionStartDate = art.getAuctionStartDate();
        this.auctionEndDate = art.getAuctionEndDate();
    }
}
