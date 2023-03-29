package com.shop.Billione.dto.member;

import com.shop.Billione.vo.MemberVO;
import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private Long customerNo;
    private String email;
    private String password;

}
