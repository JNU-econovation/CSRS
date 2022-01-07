package com.weart.csrs.Controller;

import com.weart.csrs.domain.MEMBER.MEMBER;
import com.weart.csrs.service.MEMBERService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MEMBERController {
    @Autowired
    MEMBERService memberService;

    @RequestMapping(value = "/createMember.do",method = RequestMethod.POST)
    public String joinUs(MEMBER member){

        memberService.createMember(member);
        return "index";
    }
}
