package com.shop.Billione.service;

import com.shop.Billione.dto.member.RegisterDTO;
import com.shop.Billione.entity.MemberEntity;
import com.shop.Billione.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional // 로직을 처리하다가 에러가 발생하면, 변경된 데이터를 로직을 수행하기 이전 상태로 콜백 시켜준다.
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Override
    public Long registerMember(RegisterDTO dto) { //1234
        log.info("******서비스*******" + dto);
        //비밀번호 암호화
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        dto.setPassword(encoder.encode(dto.getPassword()));

        //save 메서드는 entity 타입의 파라매터만 전달가능. dto를 entity타입으로 변경해줘야 함
        // dto에 set으로 해서 VO로 형변환
        MemberEntity registerEntity = memberRepository.save(MemberEntity.toSaveEntity(dto));

        Long savedId = memberRepository.save(registerEntity).getCustomerNo();
        log.info("******서비스끝!!!!*******" + savedId);
        return savedId;
    }
}
