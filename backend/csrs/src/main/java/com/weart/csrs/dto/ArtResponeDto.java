package com.weart.csrs.dto;

import com.weart.csrs.domain.art.Art;
import lombok.Getter;

@Getter
public class ArtResponeDto {
    private String title;
    private String content;
    private Long auctionStartPrice;

    public ArtResponeDto(Art art) {
        this.title = art.getTitle();
        this.content = art.getContent();
        this.auctionStartPrice = art.getAuctionStartPrice();
    }
}
