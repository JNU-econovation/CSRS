package com.weart.csrs.service;

import com.weart.csrs.Repository.MEMBERRepository;
import com.weart.csrs.domain.MEMBER.MEMBER;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequiredArgsConstructor
@Service
public class MEMBERService {

    @Autowired
    MEMBERRepository memberRepository;


    public void createMember(MEMBER member) {
        member.setEmail(member.getEmail());
        member.setName(member.getName());
        member.setRole(Role.valueOf("USER"));
        memberRepository.save(member);
    }
    @RequestMapping(value="/login.do",method= RequestMethod.POST)
    public String loginMember(MEMBER member){
        System.out.println("member : " + member);
        return "main";
    }

}
