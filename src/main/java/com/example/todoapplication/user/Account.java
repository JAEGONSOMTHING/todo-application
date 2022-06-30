package com.example.todoapplication.user;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;


@Entity
@Getter
@NoArgsConstructor
public class Account {

    @Builder
    public Account(String email, String nickname, String password, String picture) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.picture = picture;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @Size(min = 2, max = 20)
    private String email;
    @Column(length = 50)
    @Size(min = 2, max = 20)
    private String nickname;

    private String password;
    @Column(nullable = true)
    private String picture;

    private boolean isCertificated;

    private String authenticationKey;

    public void changeAuthenticationKey(){
        authenticationKey = UUID.randomUUID().toString();
    }
    public void changeCertification(){
        isCertificated = true;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
