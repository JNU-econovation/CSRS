package com.weart.csrs.domain.art;

import com.weart.csrs.web.dto.ArtCreateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Art {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ART_ID")
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "Text", length = 500, nullable = false)
    private String content;

    @Column(nullable = false)
    private Long auctionStartPrice;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime auctionStartDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime auctionEndDate;

    @Builder
    public Art(String title, String content, Long auctionStartPrice, LocalDateTime auctionStartDate, LocalDateTime auctionEndDate) {
        this.title = title;
        this.content = content;
        this.auctionStartPrice = auctionStartPrice;
        this.auctionStartDate = auctionStartDate;
        this.auctionEndDate = auctionEndDate;
    }

    public void update(ArtCreateRequestDto artCreateRequestDto) {
        this.title = artCreateRequestDto.toArt().getTitle();
        this.content = artCreateRequestDto.toArt().getContent();
        this.auctionStartPrice = artCreateRequestDto.toArt().getAuctionStartPrice();
        this.auctionStartDate = artCreateRequestDto.toArt().getAuctionStartDate();
        this.auctionEndDate = artCreateRequestDto.toArt().getAuctionEndDate();
    }

}
