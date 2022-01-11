package com.weart.csrs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weart.csrs.domain.art.Art;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Getter
public class ArtCreateRequestDto {
    private String title;
    private String content;
    private Long auctionStartPrice;
    private LocalDateTime auctionStartDate;
    private LocalDateTime auctionEndDate;

    @Builder
    public ArtCreateRequestDto(String title, String content, Long auctionStartPrice, String auctionStartDate, String auctionEndDate) {
        this.title = title;
        this.content = content;
        this.auctionStartPrice = auctionStartPrice;
        int[] startDateInfos = parsingDate(auctionStartDate);
        this.auctionStartDate = LocalDateTime.of(startDateInfos[0],startDateInfos[1],startDateInfos[2],startDateInfos[3],startDateInfos[4]);
        int[] endDateInfos = parsingDate(auctionEndDate);
        this.auctionEndDate = LocalDateTime.of(endDateInfos[0],endDateInfos[1],endDateInfos[2],endDateInfos[3],endDateInfos[4]);
    }

    public int[] parsingDate(String auctionDate) {
        StringTokenizer st = new StringTokenizer(auctionDate, "-");
        List<Integer> dateInformations = new ArrayList<>();
        while (st.hasMoreTokens()) {
            dateInformations.add(Integer.parseInt(st.nextToken()));
        }
        return dateInformations.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public Art toArt() {
        return Art.builder()
                .title(title)
                .content(content)
                .auctionStartPrice(auctionStartPrice)
                .auctionStartDate(auctionStartDate)
                .auctionEndDate(auctionEndDate)
                .build();
    }
}
