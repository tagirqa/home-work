package com.sbrf.reboot.service;

import com.github.tagirqa.Account;
import com.github.tagirqa.AccountRepository;
import com.github.tagirqa.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

class AccountServiceTest {

    AccountRepository accountRepository;
    AccountService accountService;
    Set<Account> accounts;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);

        accountService = new AccountService(accountRepository);

        accounts = new HashSet();
    }

    @Test
    void bookExist() throws FileNotFoundException {
        Account account = new Account("ACC1234NUM");
        accounts.add(account);

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        Assertions.assertTrue(accountService.isAccountExist(1L, account));
    }

    @Test
    void bookNotExist() throws FileNotFoundException {
        accounts.add(new Account("ACC1234NUM"));

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        Assertions.assertFalse(accountService.isAccountExist(1L, new Account("ACC456NUM")));
    }
}