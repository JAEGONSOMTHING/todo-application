package com.example.todoapplication.user;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;



public class UserAccount extends User {



    private Account account;

    public Account getAccount() {
        return account;
    }

    public UserAccount(Account account) {
        super(account.getEmail(), account.getPassword(), Collections.emptyList());
        this.account = account;
        System.out.println(account);
        System.out.println("@!#@!#!");
    }
}
