package com.weart.csrs.domain.watchlist;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.art.Art;
import com.weart.csrs.web.dto.WatchListRequestDto;
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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class WatchList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WATCH_LIST_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ART_ID")
    private Art art;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date addedDate;

    @Column(nullable = false)
    private Boolean alarmFlag;

    @Builder
    public WatchList(Art art,Member member, Date addedDate, Boolean alarmFlag) {
        this.art = art;
        this.member = member;
        this.addedDate = addedDate;
        this.alarmFlag = alarmFlag;
    }

    public void update(WatchListRequestDto watchlistRequestDto) {
        this.art = watchlistRequestDto.toWatchList().getArt();
        this.member = watchlistRequestDto.toWatchList().getMember();
        this.addedDate = watchlistRequestDto.toWatchList().getAddedDate();
        this.alarmFlag = watchlistRequestDto.toWatchList().getAlarmFlag();
    }
}
