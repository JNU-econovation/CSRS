package com.weart.csrs.web.controller;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.service.MemberService;
import com.weart.csrs.web.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @PostMapping("api/signup")
    public String signup(@RequestBody MemberSaveRequestDto memberDto) {
        return memberService.save(memberDto);
    }

    @PostMapping("api/login")
    public String login(@RequestBody MemberSaveRequestDto memberSaveRequestDto, HttpServletRequest request, RedirectAttributes rttr){
        HttpSession session = request.getSession();

        String name = memberSaveRequestDto.getUsername();
        String password = memberSaveRequestDto.getPassword();

        List<Member> member = memberService.login(name, password);

        if(member == null){
            int result = 0;
            rttr.addAttribute("result", result);
            return "redirect:/failPage";
        }else if(member !=null){
            session.setAttribute("member", member);
            return "redirect:/mainPage";
        }
        return "Something";
    }

//    @PostMapping("api/login.do")
//    public String login(@RequestBody MemberSaveRequestDto memberSaveRequestDto, Model model){
//        String name = memberSaveRequestDto.getUsername();
//        String password = memberSaveRequestDto.getPassword();
//        memberService.login(name, password);
//
//        if(memberSaveRequestDto==null){
//            model.addAttribute("loginMessage","아이디 혹은 비밀번호가 일치하지 않습니다!");
//            return "index";
//        }
//        return "main";
//    }


    @DeleteMapping("api/delete/{memberId}")
    public String deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
        return "redirect:/";
    }
    @PutMapping("api/update/{memberID}")
    public String updateMember(@PathVariable Long memberId, @RequestBody MemberSaveRequestDto memberSaveRequestDto){
        memberService.updateMember(memberId, memberSaveRequestDto);
        return "redirect:/";
    }
}