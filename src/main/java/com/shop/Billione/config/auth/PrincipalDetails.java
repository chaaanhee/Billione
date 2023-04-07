package com.shop.Billione.config.auth;

// 시큐리티가 /loginPost 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인 진행이 완료되면 시큐리티 session을 만들어 준다.
// session 공간은 똑같지만 키값으로 구분해서 (Security ContextHolder 라는 키 값)에 세션 정보 보관
// Security ContextHolder에 들어갈 수 있는 session의 오브젝트가 정해져있다. == Authentication 타입의 객체
// Authentication 안에 User 정보가 있어야 된다.
// User 오브젝트의 타입은 UserDetails 타입의 객체여야 한다.

// Security session => Authentication => UserDetails(PrincipalDetails)

import com.shop.Billione.entity.MemberEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


public class PrincipalDetails implements UserDetails {
    private MemberEntity member; //콤포지션
    public PrincipalDetails(MemberEntity member){
        this.member = member;
    }

    // 해당 user의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // member의 role이 String 타입이라 GrantedAuthority타입으로 형변환 시켜줘야 함.
        Collection<GrantedAuthority> collect = new ArrayList<>();
       collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole().getDescription();
            }
        });
        return collect;


    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getName();
    }

    /*해당 계정이 만료 상태 관련 메서드*/
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /*계정 Lock 걸렸는지*/
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /*계정 비밀번호 유효기간*/
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /*계정 활성화*/
    @Override
    public boolean isEnabled() {
        // 사이트에서 1년동안 회원이 로그인을 하지 않으면 휴면계정으로 정했다면,
        // entity에 Timestamp loginDate를 넣어 로그인할때마다 날짜를 갱신
        //get.loginDate();
        //현제시간 - 로그인시간 => 1년을 초과하면 return을 false
        return true;
    }
}
