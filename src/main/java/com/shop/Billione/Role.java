package com.shop.Billione;

import lombok.Getter;

@Getter
public enum Role {
    admin("ROLE_admin"),
    member("ROLE_member");

    private String description;
    Role(String description) {
        this.description = description;
    }
}