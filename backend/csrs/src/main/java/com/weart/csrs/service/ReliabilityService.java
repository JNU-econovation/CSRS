package com.weart.csrs.service;

import com.weart.csrs.domain.reliability.ReliabilityRepository;
import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.reliability.Reliability;
import com.weart.csrs.web.dto.ReliabilityRequestDto;
import com.weart.csrs.web.dto.ReliabilityResponseDto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@Getter
@Service
public class ReliabilityService {

    private static final String NOT_FOUND_MEMBER_MESSAGE = "ERR_MESSAGE";

    private final ReliabilityRepository reliabilityRepository;


    public Reliability selectReliabilityById(Long id){
        Reliability MemberReliability = reliabilityRepository.findByMemberId(id)
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_MEMBER_MESSAGE));
        return MemberReliability;
    }

    Member member;

    @Autowired
    public ReliabilityService(ReliabilityRepository reliabilityRepository) {
        this.reliabilityRepository = reliabilityRepository;
    }

    @Transactional
    public Long createReliability(ReliabilityRequestDto reliabilityRequestDto){
        Reliability reliability = reliabilityRepository.save(reliabilityRequestDto.toReliability());
        return reliability.getId();
    }


    @Transactional
    public boolean FlagGenerator(Long id,LocalDateTime dateTime, boolean deadFlag){
        LocalDateTime current_Time = LocalDateTime.now();
            if(current_Time == dateTime){
            if(deadFlag == false){
                return true;
            }
        }
        return false;
    }

    //deadFlag 라인에 FlagGenerator return 값 대입하면 됨.
    @Transactional
    public void minusReliability(ReliabilityResponseDto reliabilityResponseDto, boolean deadFlag) {
        if (deadFlag) {
            Reliability currentReliability = reliabilityRepository.save(Reliability.builder()
                    .successfulBid(reliabilityResponseDto.getSuccessfulBid())
                    .warningScore(reliabilityResponseDto.getWarningScore() + 1).build());
        }
    }

//    신뢰도가 -2가 된다면 Role GUEST로 변환
//    백엔드 내에서 처리하기 때문에 Dto를 사용하지않고 거래정지
//    거래정지 서비스는 제공하지 않고 warningPoint 만 제출하기로 했다.
    @Transactional
    public Long Transaction_Suspension(ReliabilityResponseDto reliabilityResponseDto){
        Long warningPoint = reliabilityResponseDto.getWarningScore();
        if( warningPoint == 2){
            return warningPoint;
        }
        return warningPoint;
    }



    //UPDATE
    @Transactional
    public Reliability update(Long memberid, ReliabilityRequestDto reliabilityRequestDto) {
        //조회시 없으면 에러 표시
    //반환형 <Optional> Reliability
        Reliability reliability = reliabilityRepository.findByMemberId(memberid)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MEMBER_MESSAGE));
            reliability.update(reliabilityRequestDto);
            return reliability;
        }
}
