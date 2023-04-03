package com.shop.Billione.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@Log4j2
@RequiredArgsConstructor // 생성자 주입
public class DashboardController {
    @GetMapping("")
    public String admin(){
        return "/admin/dashboard";
    }



}
