package com.weart.csrs.web.dto;

import com.weart.csrs.domain.credit.Credit;
import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.successfulbid.SuccessfulBid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreditRequestDto {
    private Long balance;
    private Member member;
//    private SuccessfulBid successfulBid;

    @Builder
    public CreditRequestDto(Long balance, Member member, SuccessfulBid successfulBid) {
        this.balance = balance;
        this.member = member;
//        this.successfulBid = successfulBid;
    }

    public static Credit toCredit(CreditRequestDto creditRequestDto, Member member) {
        return Credit.builder()
                .balance(creditRequestDto.getBalance())
                .member(member)
//                .successfulBid(successfulBid)
                .build();
    }
}
