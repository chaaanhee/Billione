package com.shop.Billione.repository;

import com.shop.Billione.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//CRUD 함수를 JpaRepository가 들고있다.
//@Repository가 없어도 IoC가 된다. >> JpaRepository를 상속했기 때문에
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    //기본적인 CRUD만 갖고있기때문에 추가
    //Jpa Query methods
    // findBy규칙 -> Email 문법
    //select * from memberEntity where email = 1?
    public MemberEntity findByEmail(String username);

}
