package com.weart.csrs.domain.successfulbid;

import com.weart.csrs.domain.BaseTimeEntity;
import com.weart.csrs.domain.bid.Bid;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SuccessfulBid extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUCCESSFUL_BID_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "BID_ID")
    private Bid bid;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @Column(nullable = false)
    private Boolean purchaseFlag;
}
