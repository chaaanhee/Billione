package com.shop.Billione.controller.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor // 생성자 주입
public class MemberController {
    @GetMapping("/login")
    public String login(){
        return "/customer/member/login";
    }



}
