package com.weart.csrs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final HttpSession httpSession;

    @Controller
    public class HomeController {
        @GetMapping("/")
        public String home() {
            return "home";
        }
    }
}
