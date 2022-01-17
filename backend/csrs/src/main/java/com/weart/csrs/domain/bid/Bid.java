package com.weart.csrs.domain.bid;

import com.weart.csrs.domain.CreateTimeEntity;
import com.weart.csrs.domain.art.Art;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
