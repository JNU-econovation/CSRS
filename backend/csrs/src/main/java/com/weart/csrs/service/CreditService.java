package com.weart.csrs.service;
import com.weart.csrs.domain.credit.Credit;
import com.weart.csrs.domain.credit.CreditRepository;
import com.weart.csrs.domain.member.Member;

import com.weart.csrs.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditService {
    private final String NOT_FOUND_MEMBER_MESSAGE = "실제 유저가 없습니다.";
    private final CreditRepository creditRepository;

    @Autowired
    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Transactional
    public Credit createCredit(Long memberid, Credit credit) {
        Credit member = creditRepository.findByMemberId(memberid);
        credit = creditRepository.save(member);
        return credit;
    }

    @Transactional
    public Long updateCredit(Long creditId, Credit creditRequest) {
        Credit credit1 = creditRepository.findById(creditId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MEMBER_MESSAGE));
        credit1.update(creditRequest);
        return creditId;
    }

    @Transactional
    public Credit selectCredit(Long memberId) {
        Credit credit = creditRepository.findByMemberId(memberId);
        return credit;
    }

}