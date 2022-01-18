package com.weart.csrs.web.controller;

import com.weart.csrs.service.CreditService;
import com.weart.csrs.domain.credit.Credit;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    //멤버의 Credit생성해주기
    @PostMapping("api/credit/{creditId}")
    public Credit createCredit(@PathVariable Long memberid, @RequestBody Credit credit) {
        return creditService.createCredit(memberid, credit);
    }


    //update
    @PutMapping("api/credit/{memberId}")
    public Long creditUpdate(@PathVariable Long memberId, @RequestBody Credit credit) {
        return creditService.updateCredit(memberId, credit);
    }


    // 조회
    @GetMapping("api/credit/{memberId}")
    public Credit selectCredit(@PathVariable Long memberId) {
        return creditService.selectCredit(memberId);
    }
}