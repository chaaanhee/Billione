package com.shop.Billione.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private Long customerNo;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String snsCheck;


}
