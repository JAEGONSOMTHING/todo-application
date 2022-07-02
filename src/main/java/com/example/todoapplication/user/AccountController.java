package com.example.todoapplication.user;

import com.example.todoapplication.annotation.CurrentUser;
import com.example.todoapplication.annotation.Trace;
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

    @Trace
    @PostMapping("/user")
    public ResponseEntity<AccountDto> signupUser(@RequestBody AccountDto accountDto){

        return ResponseEntity.ok().body(accountService.signUpUser(accountDto));
    }


    @Trace
    @PostMapping("/user/{id}")
    public ResponseEntity<AccountDto> changeUserProfile(@CurrentUser Account account,  @RequestBody AccountDto accountDto){
        if (canChangeUserProfile(account, accountDto)){
            throw new IllegalStateException("");
        }
        return ResponseEntity.ok().body(accountService.changeUserProfile(account.getId(), accountDto));

    }
    private boolean canChangeUserProfile(Account account, AccountDto accountDto){
        if (account==null || accountDto==null || accountDto.getId()==null || account.getId()!= accountDto.getId()){
            return false;
        }
        return true;
    }


}
