package com.example.makersMVP.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String userEmail;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String userEmail) {
        this.userEmail = userEmail;
    }

    public UserDTO(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }
}
