package com.weart.csrs.web.dto;

import com.weart.csrs.domain.art.Art;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static com.weart.csrs.util.Parser.parsingDate;

@Getter
@Setter
@NoArgsConstructor
public class ArtCreateRequestDto {
    private String title;
    private String content;
    private String category;
    private String uploadFilePath;
    private Long auctionStartPrice;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime auctionStartDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime auctionEndDate;
    private MultipartFile multipartFile;

    public Art toArt() {
        return Art.builder()
                .title(title)
                .content(content)
                .category(category)
                .uploadFilePath(uploadFilePath)
                .auctionStartPrice(auctionStartPrice)
                .auctionStartDate(auctionStartDate)
                .auctionEndDate(auctionEndDate)
                .build();
    }

    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }
}
