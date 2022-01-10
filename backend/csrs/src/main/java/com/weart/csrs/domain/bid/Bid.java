package com.weart.csrs.domain.bid;

import com.weart.csrs.domain.art.Art;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BID_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ART_ID")
    private Art art;

    @Column(nullable = false)
    private Long bidPrice;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date bidDate;
}
