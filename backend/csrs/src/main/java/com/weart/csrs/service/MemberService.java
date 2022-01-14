package com.weart.csrs.service;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.member.MemberRepository;
import com.weart.csrs.domain.member.Role;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Transactional
@Getter
@Service
public class MemberService {

    private final MemberRepository memberRepository;

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

    public void createMember(Member member) {
        member.setEmail(member.getEmail());
        member.setName(member.getName());
        member.setRole(Role.valueOf("USER"));
        memberRepository.save(member);
    }


    //Email로 계정 하나만 생성 가능.
//    private void validateDuplicateMember(MEMBER member) {
//        memberRepository.findByEmail(member.getEmail())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
//    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String loginMember(Member member) {
        System.out.println("member : " + member);
        return "main";
    }

}
