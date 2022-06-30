package com.example.todoapplication.user;

import com.example.todoapplication.util.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends GenericMapper<AccountDto, Account> {

}
