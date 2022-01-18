package com.weart.csrs.domain.reliability;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.successfulbid.SuccessfulBid;
import com.weart.csrs.web.dto.ReliabilityRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reliability {
    @Id
    @Column(name = "RELIABILITY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID")
    public Member member;

    @OneToOne
    @JoinColumn(name = "SUCCESSFUL_BID_ID")
    private SuccessfulBid successfulBid;

    @Column(nullable = false)
    private Long warningScore;

    @Builder
    public Reliability(Long id, SuccessfulBid successfulBid, Long warningScore) {
        this.id = id;
        this.successfulBid = successfulBid;
        this.warningScore = warningScore;
    }
    public void update(ReliabilityRequestDto reliabilityRequestDto) {
        this.successfulBid = reliabilityRequestDto.getSuccessfulBid();
        this.warningScore = reliabilityRequestDto.getWarningScore();
    }

}
