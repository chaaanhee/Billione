package com.shop.Billione.config.auth;

import com.shop.Billione.entity.MemberEntity;
import com.shop.Billione.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 loginProcessingUrl("/loginForm");
// login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어있는 loadUserByUsername 함수가 실행 => 규칙임
@Service // IoC로 등록
@Log4j2
public class PrincipalDetailsService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    // Security session(Authentication(UserDetails))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity memberEntity = memberRepository.findByEmail(username);
        /* 이메일이 있다면 */
        if(memberEntity != null){
            log.info("******스프링 시큐리티 로그인 되랏******* " + username);
            return new PrincipalDetails(memberEntity);
            // UserDetails 타입, 리턴될때 Authentication가 생성, 생성 후  Security session에 들어간다.
        }
        return null;
    }
}
