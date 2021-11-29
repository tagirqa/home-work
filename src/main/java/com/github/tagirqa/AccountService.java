package com.github.tagirqa;

import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;

@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public boolean isAccountExist(long l, Account account) throws FileNotFoundException {
        return accountRepository.getAllAccountsByClientId(l).contains(account);
    }
}
