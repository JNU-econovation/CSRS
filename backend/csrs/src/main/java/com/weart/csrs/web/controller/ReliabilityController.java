package com.weart.csrs.web.dto.controller;

import com.weart.csrs.domain.reliability.Reliability;
import com.weart.csrs.domain.successfulbid.SuccessfulBid;
import com.weart.csrs.service.ReliabilityService;
import com.weart.csrs.web.dto.ReliabilityRequestDto;
import com.weart.csrs.web.dto.ReliabilityResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ComponentScan({"com.weart.csrs.service.ReliabilityService"})
@Controller
public class ReliabilityController {

    private final ReliabilityService reliabilityService;
    @Autowired  //스프링컨테이너에있는 reliabilityService 를 가져와 연결.
    public ReliabilityController(ReliabilityService reliabilityService) {
        this.reliabilityService = reliabilityService;
    }


    //memberid로 reliability 조회하기
    @GetMapping("api/reliability/{id}")
    public Reliability selectReliabilityByMemberId(@PathVariable Long id) {
        return reliabilityService.selectReliabilityById(id);
    }

    //Map데이터형으로 받아서 해당 유저의 warningScore뿌려주기
    @PutMapping("api/reliability/{id}")
    public Map<String, Object> requestWarningScore(@PathVariable("MEMBER_ID") Long id, @RequestBody final ReliabilityRequestDto reliabilityRequestDto){
        Map<String, Object> response = new HashMap<>();
        Reliability reliability = reliabilityService.update(id,reliabilityRequestDto);
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
    @PostMapping("api/reliability/lower/{id}")
    public void minusReliability(@PathVariable("MEMBER_ID") Long id, ReliabilityResponseDto reliabilityResponseDto) {

        Reliability reliability = reliabilityService.selectReliabilityById(id);

        // successfulBidResponse중에서 memberid에 해당하는 값을 찾아와야함.
        SuccessfulBid successfulBid = reliability.getSuccessfulBid();

        LocalDateTime deadLine = successfulBid.getDeadline();
        boolean deadFlag = successfulBid.getPurchaseFlag();
        boolean flag = reliabilityService.FlagGenerator(id, deadLine, deadFlag);

        reliabilityService.minusReliability(reliabilityResponseDto, flag);
    }
}

