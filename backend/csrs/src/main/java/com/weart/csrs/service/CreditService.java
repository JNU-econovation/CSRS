package com.weart.csrs.service;

import com.weart.csrs.domain.credit.Credit;
import com.weart.csrs.domain.credit.CreditRepository;
import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.member.MemberRepository;
import com.weart.csrs.web.dto.CreditRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.weart.csrs.web.dto.CreditRequestDto.toCredit;

@RequiredArgsConstructor
@Service
public class CreditService {
    private final String NOT_FOUND_CREDIT_MESSAGE = "실제 유저가 없습니다.";
    private final CreditRepository creditRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long createCredit(Long memberId,CreditRequestDto creditRequestDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("No member"));
        Credit credit_find = creditRepository.save(toCredit(creditRequestDto,member));
        return credit_find.getBalance();
    }
    //Credit 삭제하기
    @Transactional
    public Long deleteCredit(Long creditId){
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_CREDIT_MESSAGE));
        creditRepository.delete(credit);
        return creditId;
    }

    @Transactional
    public Long updateCredit(Long creditId, CreditRequestDto creditRequestDto) {
        Credit credit1 = creditRepository.findById(creditId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_CREDIT_MESSAGE));
        credit1.update(creditRequestDto);
        return creditId;
    }

    @Transactional
    public Long transaction(Long creditId, CreditRequestDto creditRequestDto){

        Credit loadedCredit = creditRepository.findById(creditId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_CREDIT_MESSAGE));
        //new Credit
        Long bidPrice = creditRequestDto.getBalance();
        Long new_balance = loadedCredit.getBalance() - bidPrice;

        //유저의 크래딧 가져오기
//        creditRepository.save(toCredit(new_balance));
        //갱신가격 저장.
        loadedCredit.setBalance(new_balance);
//        loadedCredit.update();

        return creditId;
    }

    @Transactional
    public List<Credit> selectCredit(Long memberId) {
        List<Credit> credit = creditRepository.findByMemberId(memberId);
        return credit;
    }

}