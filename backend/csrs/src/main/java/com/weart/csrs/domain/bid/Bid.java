package com.weart.csrs.domain.bid;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.CreateTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Bid extends CreateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BID_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ART_ID")
    private Art art;

    @Column(nullable = false)
    private Long bidPrice;

    @Builder
    public Bid(Art art, Long bidPrice) {
        this.art = art;
        this.bidPrice = bidPrice;
    }
}