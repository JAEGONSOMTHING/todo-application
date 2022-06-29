package com.example.todoapplication.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAccount loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("email is  not exist"));

        return new UserAccount(account);
    }

    public AccountDto signUpUser(AccountDto accountDto){
        if (emailIsAlreadyExist(accountDto.getEmail())){
            throw new IllegalArgumentException("exist email");
        }

        Account account = accountMapper.toEntity(accountDto);
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        account.changeAuthenticationKey();
        accountRepository.save(account);

        return accountMapper.toDto(account);

    }
    private boolean emailIsAlreadyExist(String email){
        return accountRepository.existsByEmail(email);
    }


    public AccountDto changeUserProfile(Long userId, AccountDto accountDto){

        Account account = accountRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not exist"));
        accountMapper.updateFromDto(accountDto, account);
        return accountMapper.toDto(account);
    }



}
