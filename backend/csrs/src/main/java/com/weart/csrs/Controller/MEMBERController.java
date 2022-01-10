package com.weart.csrs.Controller;

import com.weart.csrs.domain.MEMBER.MEMBER;
import com.weart.csrs.service.MEMBERService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@ComponentScan({"com.weart.csrs.service.MEMBERService"})
public class MEMBERController {

    @Autowired  //스프링컨테이너에있는 memberService 를 가져와 연결.
    public MEMBERController(MEMBERService memberService) {
        this.memberService = memberService;
    }

    private final MEMBERService memberService;
    protected Logger log = LoggerFactory.getLogger(this.getClass());

//    생성자로 연결

    //    회원가입 뷰
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("account", new MEMBER());
        return "/auth/registration";
    }

    //    회원가입 폼
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createMEMBER(Model model, MEMBER member, BindingResult bindingResult) {
        try {
            List<MEMBER> memberExist = memberService.getByName(member.getName());
            if (memberExist != null) {
                bindingResult.rejectValue("name", "error.member", "기존에 있는 사용자 입니다");
            } else {
                memberService.createMember(member);
                model.addAttribute("member", new MEMBER());
                model.addAttribute("successMessage", "회원가입 성공");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            model.addAttribute("successMessage", "FAIL" + e.getMessage());
        }
        return "auth/registration";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<MEMBER> member = null;
        try{
            member = memberService.getByName(auth.getName());
        }catch ( Exception e){
            log.error(e.getMessage());
        }
        model.addAttribute("username", memberService.getByName(auth.getName()));
        model.addAttribute("adminMessage", "Content Available Only for Users with Admin Role");

        return "/index";
    }

//    Admin HomePage Redirect
    @RequestMapping(value = "/home/admin", method = RequestMethod.GET)
    public String adminHome(Model model) {
        return "/home/admin";
    }

//    User HomePage Redirect
    @RequestMapping(value = "/home/user", method = RequestMethod.GET)
    public String userHome(Model model) {
        return "/home/user";
    }

    //    guest HomePage Redirect
    @RequestMapping(value = "/home/guest", method = RequestMethod.GET)
    public String guestHome(Model model) {
        return "/home/guest";
    }

}
