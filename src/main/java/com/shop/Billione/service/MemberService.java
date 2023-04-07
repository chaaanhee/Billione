package com.shop.Billione.service;

import com.shop.Billione.dto.member.RegisterDTO;
import com.shop.Billione.entity.MemberEntity;

import java.util.List;

public interface MemberService {
    Long registerMember(RegisterDTO registerDTO) throws Exception ;

}
