package com.weart.csrs.web.controller;

import com.weart.csrs.domain.reliability.Reliability;
import com.weart.csrs.service.ReliabilityService;
import com.weart.csrs.web.dto.ReliabilityRequestDto;
import com.weart.csrs.web.dto.ReliabilityResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ReliabilityController {

    private final ReliabilityService reliabilityService;

    @PostMapping("api/reliability/{memberId}")
    public Long createReliability(@PathVariable Long memberId,@RequestBody ReliabilityRequestDto reliabilityRequestDto) {
        return reliabilityService.createReliability(memberId, reliabilityRequestDto);
    }


    //memberid로 reliability 조회하기
//    @GetMapping("api/reliability/{id}")
//    public Reliability selectReliabilityById(@PathVariable Long id) {
////        return reliabilityService.selectReliabilityById(id);
//        return reliabilityService.ge
//    }
//    2022.01.23 내일 서현아 힘내.


    //Map데이터형으로 받아서 해당 유저의 warningScore뿌려주기
    @PutMapping("api/reliability/{memberId}")
    public Map<String, Object> requestWarningScore(@PathVariable("memberId") Long memberId, @RequestBody final ReliabilityRequestDto reliabilityRequestDto){
        Map<String, Object> response = new HashMap<>();
        Reliability reliability = reliabilityService.update(memberId, reliabilityRequestDto);
        if(reliability != null){
            response.put("result","Success");
            response.put("warningScore",reliability.getWarningScore());
        }
        else{
            response.put("result","FAIL");
            response.put("reason","일치하는 회원이 없습니다. 사용자 id를 확인해주세요.");
        }
        return response;
    }

    //responsedto, boolean deadFlag()
    //public boolean FlagGenerator(SuccessfulBidResponse successfulBidResponse){
    //해당 유저의 id를 받아서 신뢰도 감소시키는 요청.
    @PutMapping("api/reliability/lower/{memberId}")
    public void minusReliability(@PathVariable("memberId") Long memberId, ReliabilityResponseDto reliabilityResponseDto) {

        List<Reliability> reliability = reliabilityService.selectReliabilityByMemberId(memberId);

        // successfulBidResponse중에서 memberid에 해당하는 값을 찾아와야함.
//        SuccessfulBid successfulBid = reliability.getSuccessfulBid();
//
//        LocalDateTime deadLine = successfulBid.getDeadline();
//        boolean deadFlag = successfulBid.getPurchaseFlag();
//        boolean flag = reliabilityService.FlagGenerator(deadLine, deadFlag);
//
//        reliabilityService.minusReliability(reliabilityResponseDto, flag);
    }
}
