//package com.weart.csrs.web.dto;
//
//import com.weart.csrs.domain.member.Member;
//import com.weart.csrs.domain.reliability.Reliability;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Getter
//@NoArgsConstructor
//public class ReliabilityRequestDto {
//    private Member member;
//    private Long warningScore;
//
//    @Builder
//    public ReliabilityRequestDto(Member member, Long warningScore) {
//        this.member = member;
//        this.warningScore = warningScore;
//    }
//
//
//    public static Reliability toReliability(Member member, ReliabilityRequestDto reliabilityRequestDto){
//        return Reliability.builder()
//                .warningScore(reliabilityRequestDto.getWarningScore())
//                .member(member)
//                .build();
//    }
//}