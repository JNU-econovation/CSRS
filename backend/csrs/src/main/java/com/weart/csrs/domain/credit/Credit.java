package com.weart.csrs.domain.credit;

import com.weart.csrs.domain.BaseTimeEntity;
import com.weart.csrs.domain.successfulbid.SuccessfulBid;

import javax.persistence.*;

@Entity
public class Credit extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CREDIT_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "SUCCESSFUL_BID_ID")
    private SuccessfulBid successfulBid;

    @Column(nullable = false)
    private Long balance;
}
