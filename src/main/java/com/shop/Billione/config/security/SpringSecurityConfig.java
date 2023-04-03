package com.shop.Billione.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    /*비밀번호 암호화 저장*/
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /*인증을 무시하기 위한 설정*/
    @Override
    public void configure(WebSecurity web) throws Exception{
        web
                .ignoring()
                .antMatchers( "/css/**", "/js/**", "/img/**","/lib/**","/scss/**","/vendor/**");
    }
    /*로그인 설정*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/mypage/**").authenticated()
                    .antMatchers("/admin/**").hasRole("admin")
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/loginPost")
                    .usernameParameter("email") //loadUserByUsername에서 사용해야하니까 반드시 있어야함
                    .passwordParameter("password")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true) // 로그아웃 후 세션 초기화 설정
                    .deleteCookies("JSESSIONID") // 로그아웃 후 쿠기 삭제 설정
                    .and()
                .exceptionHandling(); //인증인가 예외발생시 처리
    }



}