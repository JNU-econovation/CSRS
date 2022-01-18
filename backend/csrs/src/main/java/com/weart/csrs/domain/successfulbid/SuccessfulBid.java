package com.weart.csrs.domain.successfulbid;

import com.weart.csrs.domain.bid.Bid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SuccessfulBid {
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