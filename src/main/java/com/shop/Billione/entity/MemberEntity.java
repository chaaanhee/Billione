package com.shop.Billione.entity;

import com.shop.Billione.Role;
import com.shop.Billione.dto.member.RegisterDTO;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@DynamicInsert //insert시 null 필드를 제외시켜줌
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNo;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String phone;
    @Column(length = 1, nullable = false)
    private String snsCheck;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ColumnDefault("'B'")
    @Column(length = 1)
    private String customerRank;

    @CreationTimestamp
    @Column(nullable = false,  columnDefinition = "TIMESTAMP DEFAULT now()")
    private Timestamp enrollDate;
    @ColumnDefault("'N'")
    @Column(length = 1)
    private String withdraw;

    public static MemberEntity toSaveEntity(RegisterDTO registerDTO){

        MemberEntity registerEntity = new MemberEntity();
        registerEntity.setEmail(registerDTO.getEmail());
        registerEntity.setPassword(registerDTO.getPassword());
        registerEntity.setName(registerDTO.getName());
        registerEntity.setPhone(registerDTO.getPhone());
        registerEntity.setSnsCheck(registerDTO.getSnsCheck());
        registerEntity.setRole(Role.member);
        return registerEntity;

    }


}
