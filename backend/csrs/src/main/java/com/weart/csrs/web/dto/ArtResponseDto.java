package com.weart.csrs.web.dto;

import com.weart.csrs.domain.art.Art;
import lombok.Getter;
import software.amazon.ion.Decimal;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

import static com.weart.csrs.util.StringUtils.expressPrice;


@Getter
public class ArtResponseDto {
    private Long id;
    private String title;
    private String content;
    private String auctionStartPrice;
    private LocalDateTime auctionStartDate;
    private LocalDateTime auctionEndDate;
    private Long dueDate;

    public ArtResponseDto(Art art) {
        this.id = art.getId();
        this.title = art.getTitle();
        this.content = art.getContent();
        this.auctionStartPrice = expressPrice(art.getAuctionStartPrice());
        this.auctionStartDate = art.getAuctionStartDate();
        this.auctionEndDate = art.getAuctionEndDate();
        dueDate = art.calculateDate(auctionEndDate);
    }
}
