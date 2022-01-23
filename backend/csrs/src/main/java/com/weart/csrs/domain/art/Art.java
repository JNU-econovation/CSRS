package com.weart.csrs.domain.art;

import com.weart.csrs.domain.BaseTimeEntity;
import com.weart.csrs.domain.member.Member;
import com.weart.csrs.web.dto.ArtCreateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Art extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ART_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", length = 500, nullable = false)
    private String content;

    @Column(nullable = false)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String uploadFilePath;

    @Column(nullable = false)
    private Long auctionStartPrice;

    @Column(nullable = false)
    private LocalDateTime auctionStartDate;

    @Column(nullable = false)
    private LocalDateTime auctionEndDate;

    @Transient
    private Boolean isStartBid;

    @Transient
    private Boolean isEndBid;

    @Builder
    public Art(String title, String content, String category, String uploadFilePath, Long auctionStartPrice, LocalDateTime auctionStartDate, LocalDateTime auctionEndDate) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.uploadFilePath = uploadFilePath;
        this.auctionStartPrice = auctionStartPrice;
        this.auctionStartDate = auctionStartDate;
        this.auctionEndDate = auctionEndDate;
    }

    public void update(ArtCreateRequestDto artCreateRequestDto) {
        this.title = artCreateRequestDto.getTitle();
        this.content = artCreateRequestDto.getContent();
        this.category = category;
        this.auctionStartPrice = artCreateRequestDto.getAuctionStartPrice();
        this.auctionStartDate = artCreateRequestDto.getAuctionStartDate();
        this.auctionEndDate = artCreateRequestDto.getAuctionEndDate();
    }

    public Boolean checkBidTime(){
        isStartBid = false;
        LocalDateTime currentTime = LocalDateTime.now();
        if(currentTime.isAfter(auctionStartDate) || currentTime.isEqual(auctionStartDate)){
            isStartBid = true;
        }
        return isStartBid;
    }

    public Boolean checkBidEndTime() {
        isEndBid = true;
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isBefore(auctionEndDate)) {
            isEndBid = false;
        }
        return isEndBid;
    }
}
