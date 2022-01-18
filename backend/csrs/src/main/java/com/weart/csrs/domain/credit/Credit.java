package com.weart.csrs.domain.credit;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.successfulbid.SuccessfulBid;
import lombok.Builder;

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

@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CREDIT_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID")
    public Member member;

    @OneToOne
    @JoinColumn(name = "SUCCESSFUL_BID_ID")
    private SuccessfulBid successfulBid;

    @Column(nullable = false)
    private Long balance;


    @Builder
    public Credit(Long id, SuccessfulBid successfulBid, Long balance) {
        this.id = id;
        this.successfulBid = successfulBid;
        this.balance = balance;
    }
    public void update(Credit credit) {
        this.member = credit.member;
        this.successfulBid = credit.successfulBid;
        this.balance = credit.balance;
    }
}