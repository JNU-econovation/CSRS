package com.weart.csrs.service;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.member.MemberRepository;
import com.weart.csrs.web.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final String NOT_FOUND_MEMBER_MESSAGE = "찾으시는 유저가 존재하지 않습니다.";

    @Transactional
    public Member login(String id, String password){
    Member member = memberRepository.selectMember(id, password);
        return member;
    }

    @Transactional
    public String save(MemberSaveRequestDto requestDto) {
        Member member = memberRepository.save(requestDto.toEntity());
        return member.getUsername();
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.getById(memberId);
        memberRepository.delete(member);
    }

    @Transactional
    public void updateMember(Long memberId, MemberSaveRequestDto memberSaveRequestDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MEMBER_MESSAGE));
        memberRepository.save(member);
    }
}