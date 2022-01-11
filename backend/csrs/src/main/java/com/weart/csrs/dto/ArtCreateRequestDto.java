package com.weart.csrs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weart.csrs.domain.art.Art;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArtCreateRequestDto {
    private String title;
    private String content;
    private Long auctionStartPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime auctionStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime auctionEndDate;

    @Builder
    public ArtCreateRequestDto(String title, String content, Long auctionStartPrice) {
        this.title = title;
        this.content = content;
        this.auctionStartPrice = auctionStartPrice;
//        this.auctionStartDate = auctionStartDate;
//        this.auctionEndDate = auctionEndDate;
    }

    public Art toArt() {
        return Art.builder()
                .title(title)
                .content(content)
                .auctionStartPrice(auctionStartPrice)
//                .auctionStartDate(auctionStartDate)
//                .auctionEndDate(auctionEndDate)
                .build();
    }
}
