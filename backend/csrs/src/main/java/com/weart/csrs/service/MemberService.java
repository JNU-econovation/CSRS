package com.weart.csrs.service;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.member.MemberRepository;
import com.weart.csrs.domain.member.Role;
import com.weart.csrs.web.dto.MemberDto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Getter
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final String NOT_FOUND_MEMBER_MESSAGE = "해당 유저가 없습니다";
    public List<Member> getByName(String name) throws Exception {
        return memberRepository.findByName(name);
    }

    public Optional<Member> getByEmail(String email) throws Exception {
        return memberRepository.findByEmail(email);
    }

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long createMember(MemberDto memberDto) {
        memberDto.setEmail(memberDto.getEmail());
        memberDto.setName(memberDto.getName());
        memberDto.setRole(Role.valueOf("USER"));
        Member savedMember = memberRepository.save(memberDto.toMember());
        return savedMember.getId();
    }

    @Transactional
    public Long updateMember(Long memberId, MemberDto memberDto){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MEMBER_MESSAGE));
        return memberId;
    }

    @Transactional
    public Long deleteMember(Long memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MEMBER_MESSAGE));
        memberRepository.delete(member);
        return memberId;
    }

    //Email로 계정 하나만 생성 가능.
//    private void validateDuplicateMember(MEMBER member) {
//        memberRepository.findByEmail(member.getEmail())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
//    }

}
