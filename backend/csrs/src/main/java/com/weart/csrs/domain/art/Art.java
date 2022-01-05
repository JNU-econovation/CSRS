package com.weart.csrs.domain.art;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Art {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ART_ID")
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "Text", length = 500, nullable = false)
    private String content;

    @Column(nullable = false)
    private Long auctionStartPrice;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date auctionStartDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date auctionEndDate;
}
