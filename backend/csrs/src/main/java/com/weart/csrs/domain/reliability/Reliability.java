package com.weart.csrs.domain.reliability;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.successfulbid.SuccessfulBid;
import com.weart.csrs.web.dto.ReliabilityRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Getter
@Setter
@DynamicInsert
@NoArgsConstructor
@Entity
public class Reliability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RELIABILITY_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID")
    private Member member;

    @OneToOne
    @JoinColumn(name = "SUCCESSFUL_BID_ID")
    private SuccessfulBid successfulBid;

    @Column(columnDefinition = "Long default 0")
    private Long warningScore;

    @Builder
    public Reliability(Long id,Member member, SuccessfulBid successfulBid, Long warningScore) {
        this.id = id;
        this.successfulBid = successfulBid;
        this.warningScore = warningScore;
        this.member = member;
    }

    public void update(ReliabilityRequestDto reliabilityRequestDto) {
        this.member = reliabilityRequestDto.getMember();
        this.warningScore = reliabilityRequestDto.getWarningScore();
//        this.successfulBid = reliabilityRequestDto.getSuccessfulBid();
    }

}
