package com.example.todoapplication.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(AccountController.class)
@MockBean(JpaMetamodelMappingContext.class)
class AccountControllerTest {
    @MockBean
    PasswordEncoder passwordEncoder;
    @MockBean
    AccountService accountService;
    @Autowired
    MockMvc mockMvc;



    AccountDto accountDto;

    @BeforeEach
    void setup(){
        AccountDto accountDto = new AccountDto();
        accountDto.setEmail("imjaegon@gmail.com");
        accountDto.setPassword("12341234");
        accountDto.setNickname("임재곤");
        this.accountDto = accountDto;


    }


    @Test
    @DisplayName("회원 가입 성공 테스트")
    @WithMockUser("username")
    void signupUser() throws Exception {



    }

    @Test
    void changeUserProfile() {
    }
}