package com.weart.csrs.web.controller;

import com.weart.csrs.domain.credit.Credit;
import com.weart.csrs.service.CreditService;
import com.weart.csrs.web.dto.CreditRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    //멤버의 Credit생성해주기
    @PostMapping("api/credit/{memberId}")
    public Long createCredit(@PathVariable Long memberId,@RequestBody CreditRequestDto creditRequestDto) {
        return creditService.createCredit(memberId, creditRequestDto);
    }

    //update
    @PutMapping("api/credit/{creditId}")
    public Long creditUpdate(@PathVariable Long creditId, @RequestBody CreditRequestDto creditRequestDto) {
        return creditService.updateCredit(creditId, creditRequestDto);
    }
    //거래승낙시 차감.  RequestBody
    @PutMapping("api/credit/update/{creditId}")
    public Long transaction(@PathVariable Long creditId, @RequestBody CreditRequestDto creditRequestDto){
        return  creditService.transaction(creditId, creditRequestDto);
    }
    // 조회
    @GetMapping("api/credit/{memberId}")
    public List<Credit> selectCredit(@PathVariable Long memberId) {
        return creditService.selectCredit(memberId);
    }

    @DeleteMapping("api/credit/{creditId}")
    public Long deleteCredit(@PathVariable Long creditId){
        return creditService.deleteCredit(creditId);
    }
}