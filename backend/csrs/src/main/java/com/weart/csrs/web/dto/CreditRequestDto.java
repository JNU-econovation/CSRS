package com.weart.csrs.web.dto;

import com.weart.csrs.domain.credit.Credit;
import com.weart.csrs.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreditRequestDto {
    private Long balance;
    private Member member;

//    @Builder
//    public CreditRequestDto(Long balance) {
//        this.balance = balance;
//    }

    public static Credit toCredit(Long balance) {
        return Credit.builder()
                .balance(balance)
                .build();
    }
}
