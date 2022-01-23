package com.weart.csrs.web.controller;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.service.MemberService;
import com.weart.csrs.web.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {


    @Autowired  //스프링컨테이너에있는 memberService 를 가져와 연결.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    private final MemberService memberService;

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    //    회원가입
    @PostMapping("api/member/")
    public Long createMEMBER(Model model, @RequestBody MemberDto memberDto, BindingResult bindingResult) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            List<Member> memberExist = memberService.getByName(memberDto.getName());
            if (memberExist != null) {
                bindingResult.rejectValue("name", "error.memberDto", "기존에 있는 사용자 입니다");
            } else {
                memberService.createMember(memberDto);
                model.addAttribute("memberDto", new Member());
                model.addAttribute("successMessage", "회원가입 성공");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            model.addAttribute("successMessage", "FAIL" + e.getMessage());
        }
        return memberService.createMember(memberDto);
    }


    //조회
    @GetMapping("/api/member/list/")
    public List<Member> home(Model model) throws Exception {

//        Obtains the currently authenticated principal, or an authentication request token.
//        Returns:
//        the Authentication or null if no authentication information is available
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Member> member = null;
        try {
            member = memberService.getByName(auth.getName());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return member;
    }

//   Update
    @PutMapping("/api/member/{memberId}")
    public Long updateMember(@PathVariable Long memberId,@RequestBody MemberDto memberDto){
        return memberService.updateMember(memberId, memberDto);
    }

    //selectMember
    @GetMapping("api/member/{email}")
    public Optional<Member> selectMember(@PathVariable String email) throws Exception {
        return memberService.getByEmail(email);
    }

    //유저삭제
    @DeleteMapping("/api/member/{memberid}")
    public Long deleteMember(@PathVariable Long memberId){
        return memberService.deleteMember(memberId);
    }
}
