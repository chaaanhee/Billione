package com.shop.Billione.controller.member;

import com.shop.Billione.dto.member.LoginDTO;
import com.shop.Billione.dto.member.RegisterDTO;
import com.shop.Billione.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
@Log4j2
@RequiredArgsConstructor // 생성자 주입
public class MemberController {
    @Autowired
    MemberService memberService;
    /*로그인 페이지*/
    @GetMapping("/login")
    public String login(){
        return "/customer/member/login";
    }
    /*회원가입 페이지*/
    @GetMapping("/register")
    public String register(){
        return "/customer/member/register";
    }
    /*회원가입 페이지*/
    @GetMapping("/mypage")
    public String mypage(){
        return "/customer/member/mypage";
    }

    /* ******************************POST***************************** */

    /*로그인 post*/
    @PostMapping("/loginPost")
    public void loginPost(LoginDTO dto) throws Exception {
    }
    /*회원가입 post*/
    @PostMapping("/registerPost")
    public String registerPost(@ModelAttribute RegisterDTO dto) throws Exception {
        log.info("******컨트롤러*******" + dto);
        memberService.registerMember(dto);
    return "redirect:/login";
    }

}
