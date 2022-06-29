package com.example.todoapplication.user;

import lombok.Data;

@Data
public class AccountDto {

    private Long id;
    private String email;
    private String nickname;
    private String password;
    private String picture;

}
