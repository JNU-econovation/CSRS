package com.weart.csrs.web.dto;

import com.weart.csrs.domain.art.Art;
import lombok.Getter;

import java.time.LocalDate;

import static com.weart.csrs.util.StringUtils.expressPrice;


@Getter
public class ArtResponseDto {
    private Long id;
    private String title;
    private String content;
    private String auctionStartPrice;
    private LocalDate auctionStartDate;
    private LocalDate auctionEndDate;
    private Long dueDate;
    private String category;
    private String uploadFilePath;

    public ArtResponseDto(Art art) {
        this.id = art.getId();
        this.title = art.getTitle();
        this.content = art.getContent();
        this.auctionStartPrice = expressPrice(art.getAuctionStartPrice());
        this.auctionStartDate = art.getAuctionStartDate();
        this.auctionEndDate = art.getAuctionEndDate();
        dueDate = art.calculateDate(auctionEndDate);
        category = art.getCategory();
        uploadFilePath = art.getUploadFilePath();
    }
}
