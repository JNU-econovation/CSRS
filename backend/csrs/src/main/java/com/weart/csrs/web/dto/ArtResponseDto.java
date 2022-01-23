package com.weart.csrs.web.dto;

import com.weart.csrs.domain.art.Art;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArtResponseDto {
    private Long id;
    private String title;
    private String content;
    private Long auctionStartPrice;
    private LocalDateTime auctionStartDate;
    private LocalDateTime auctionEndDate;

    public ArtResponseDto(Art art) {
        this.id = art.getId();
        this.title = art.getTitle();
        this.content = art.getContent();
        this.auctionStartPrice = art.getAuctionStartPrice();
        this.auctionStartDate = art.getAuctionStartDate();
        this.auctionEndDate = art.getAuctionEndDate();
    }
}
