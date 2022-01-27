//package com.weart.csrs.domain.watchlist;
//
//import com.weart.csrs.domain.BaseTimeEntity;
//import com.weart.csrs.domain.art.Art;
//import com.weart.csrs.domain.member.Member;
//import com.weart.csrs.web.dto.WatchListRequestDto;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.DynamicInsert;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//@Getter
//@NoArgsConstructor
//@Entity
//@DynamicInsert
//public class WatchList extends BaseTimeEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "WATCH_LIST_ID")
//    private Long id;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "MEMBER_ID",referencedColumnName = "MEMBER_ID")
//    private Member member;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ART_ID",referencedColumnName = "ART_ID")
//    private Art art;
//
//    @Column(columnDefinition = "boolean default false")
//    private Boolean alarmFlag;
//
//    @Builder
//    public WatchList(Art art, Member member) {
//        this.art = art;
//        this.member = member;
//    }
//
//
//
//    public void update(WatchListRequestDto watchlistRequestDto) {
////        this.art = watchlistRequestDto.toWatchList().getArt();
////        this.member = watchlistRequestDto.toWatchList().getMember();
////        this.addedDate = watchlistRequestDto.toWatchList().getAddedDate();
////        this.alarmFlag = watchlistRequestDto.toWatchList().getAlarmFlag();
//    }
//}
