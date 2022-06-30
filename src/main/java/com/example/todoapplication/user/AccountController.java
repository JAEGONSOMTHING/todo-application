package com.example.todoapplication.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/user/sign-up")
    public ResponseEntity<String> signupUser(@RequestBody AccountDto accountDto){
        log.info("가입");
        log.info(accountDto.getEmail());
        accountService.signUpUser(accountDto);

        return ResponseEntity.accepted().body("welcome");
    }



}
