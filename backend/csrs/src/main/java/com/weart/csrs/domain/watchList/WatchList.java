package com.weart.csrs.domain.watchList;

import com.weart.csrs.domain.art.Art;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WatchList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WATCH_LIST_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ART_ID")
    private Art art;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date addedDate;

    @Column(nullable = false)
    private Boolean alarmFlag;
}
