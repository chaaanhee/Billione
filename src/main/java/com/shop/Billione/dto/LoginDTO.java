package com.shop.Billione.dto;

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
