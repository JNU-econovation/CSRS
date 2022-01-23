package com.weart.csrs.domain.credit;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.web.dto.CreditRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CREDIT_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID")
    private Member member;

//    @OneToOne
////    @JoinColumn(name = "SUCCESSFUL_BID_ID")
////    private SuccessfulBid successfulBid;

    @Column(columnDefinition = "Long default 500L")
    private Long balance;


    @Builder
    public Credit(Long id, Long balance) {
        this.id = id;
//        this.successfulBid = successfulBid;
        this.balance = balance;
    }

    public void update(CreditRequestDto creditRequestDto) {
        this.member = creditRequestDto.getMember();
//        this.successfulBid = credit.successfulBid;
        this.balance = creditRequestDto.getBalance();
    }


}