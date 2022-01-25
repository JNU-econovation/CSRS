package com.weart.csrs.web.dto;

import com.weart.csrs.domain.reliability.Reliability;
import com.weart.csrs.domain.successfulbid.SuccessfulBid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReliabilityRequestDto {

    private Long id;
    private SuccessfulBid successfulBid;
    private Long warningScore;

    public ReliabilityRequestDto(Reliability reliability) {
        this.id = reliability.getId();
        this.successfulBid = reliability.getSuccessfulBid();
        this.warningScore = reliability.getWarningScore();
    }

    public Reliability toReliability() {
        return Reliability.builder()
                .successfulBid(successfulBid)
                .warningScore(warningScore)
                .build();
    }
}