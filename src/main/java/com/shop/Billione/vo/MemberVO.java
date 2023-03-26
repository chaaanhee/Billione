package com.shop.Billione.vo;

import lombok.*;
import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberVO {
    private Long customerNo;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String snsCheck;
    private String identifier;
    private String customerRank;
    private Timestamp enrollDate;
    private String withdraw;



}
