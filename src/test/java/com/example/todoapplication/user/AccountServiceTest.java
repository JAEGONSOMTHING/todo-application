package com.example.todoapplication.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @Mock
    private AccountRepository accountRepository;
    @Spy
    private AccountMapperImpl accountMapper;
    @Spy
    private BCryptPasswordEncoder passwordEncoder;
    @InjectMocks
    private AccountService accountService;


    @Test
    @DisplayName("loadByUsername 존재하지 않는 이메일 테스트")
    void notExistEmailLoadByUsername() {

        String EMAIL = "abc.com";
        Account account = Account.builder().
                email(EMAIL).password("1234").nickname("jaegon").build();
        when(accountRepository.findByEmail(any())).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> accountService.loadUserByUsername(account.getEmail()));

    }

    @Test
    @DisplayName("loadByUsername 성공 테스트")
    void loadByUsername() {

        String EMAIL = "abc.com";
        Account account = Account.builder().
                email(EMAIL).password("1234").nickname("jaegon").build();
        when(accountRepository.findByEmail(any())).thenReturn(Optional.of(account));

        UserAccount user = accountService.loadUserByUsername(EMAIL);

        assertThat(user.getAccount()).usingRecursiveComparison().ignoringActualNullFields().isEqualTo(account);

    }

    @Test
    @DisplayName("존재하는 이메일로 회원가입 실패 테스트")
    void badSignUpTest() {
        AccountDto request = new AccountDto();
        request.setEmail("abc.com");
        when(accountRepository.existsByEmail(any())).thenReturn(true);

        assertThrows(RuntimeException.class, () -> accountService.signUpUser(request));
    }

    @Test
    @DisplayName("회원가입 성공 테스트")
    void signUpTest() {
        AccountDto request = new AccountDto();
        request.setEmail("email@e.mail");
        request.setNickname("worhs");
        request.setPassword("jg123");
        request.setPicture("picture");
        when(accountRepository.existsByEmail(any())).thenReturn(false);
       

        AccountDto savedAccount = accountService.signUpUser(request);


        assertTrue(passwordEncoder.matches(request.getPassword(), savedAccount.getPassword()));
        assertThat(savedAccount).usingRecursiveComparison().ignoringFields("password").isEqualTo(request);
    }

    @DisplayName("회원정보 수정 성공 테스트")
    @Test
    void changeProfileTest() {
        AccountDto accountDto = new AccountDto(1L, "email@e.mail", "jaegon", "1234", "picture");
        Account account = Account.builder().email("eeeeeeeemail@e.amil")
                .nickname("jaegonanim")
                .password("password")
                .picture("p")
                .build();

        when(accountRepository.findById(any())).thenReturn(Optional.of(account));



        AccountDto changedAccount = accountService.changeUserProfile(1L, accountDto);

        assertNull(account.getId());
        assertThat(changedAccount.getEmail()).isNotEqualTo(accountDto.getEmail());
        assertTrue(passwordEncoder.matches(accountDto.getPassword(), changedAccount.getPassword()));
        assertThat(changedAccount.getPicture()).isEqualTo(accountDto.getPicture());
        assertThat(changedAccount.getNickname()).isEqualTo(accountDto.getNickname());
    }

}