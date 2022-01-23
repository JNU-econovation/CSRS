package com.weart.csrs.web.dto;

import com.weart.csrs.domain.art.Art;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static com.weart.csrs.util.Parser.parsingDate;

@Getter
public class ArtCreateRequestDto {
    private String title;
    private String content;
    private String category;
    private Long auctionStartPrice;
    private LocalDateTime auctionStartDate;
    private LocalDateTime auctionEndDate;

    @Builder
    public ArtCreateRequestDto(String title, String content, String category, Long auctionStartPrice, String auctionStartDate, String auctionEndDate) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.auctionStartPrice = auctionStartPrice;
        int[] startDateInfos = parsingDate(auctionStartDate);
        this.auctionStartDate = LocalDateTime.of(startDateInfos[0], startDateInfos[1], startDateInfos[2], startDateInfos[3], startDateInfos[4]);
        int[] endDateInfos = parsingDate(auctionEndDate);
        this.auctionEndDate = LocalDateTime.of(endDateInfos[0], endDateInfos[1], endDateInfos[2], endDateInfos[3], endDateInfos[4]);
    }

    public Art toArt() {
        return Art.builder()
                .title(title)
                .content(content)
                .category(category)
                .auctionStartPrice(auctionStartPrice)
                .auctionStartDate(auctionStartDate)
                .auctionEndDate(auctionEndDate)
                .build();
    }
}
