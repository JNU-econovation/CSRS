package com.weart.csrs.domain.credit;

import com.weart.csrs.domain.successfulbid.SuccessfulBid;

import javax.persistence.*;

@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "SUCCESSFUL_BID_ID")
    @Column(unique = true)
    private SuccessfulBid successfulBid;

    @Column(nullable = false)
    private Long balance;
}
