package com.weart.csrs.domain.reliability;

import com.weart.csrs.domain.BaseTimeEntity;
import com.weart.csrs.domain.successfulbid.SuccessfulBid;

import javax.persistence.*;

@Entity
public class Reliability extends BaseTimeEntity {
    @Id
    @Column(name = "RELIABILITY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "SUCCESSFUL_BID_ID")
    private SuccessfulBid successfulBid;

    @Column(nullable = false)
    private Long warningScore;
}
