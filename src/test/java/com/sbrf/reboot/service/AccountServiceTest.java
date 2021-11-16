package com.sbrf.reboot.service;

import com.github.tagirqa.Account;
import com.github.tagirqa.AccountRepository;
import com.github.tagirqa.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
    void bookExist() {
        Account account = new Account("ACC1234NUM");
        accounts.add(account);

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertTrue(accountService.isAccountExist(1L, account));
    }

    @Test
    void bookNotExist() {
        accounts.add(new Account("ACC1234NUM"));

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertFalse(accountService.isAccountExist(1L, new Account("ACC456NUM")));
    }

    @Test
    void countAccountInRepository() {
        accounts.add(new Account("AAA777"));
        accounts.add(new Account("FFF111"));
        accounts.add(new Account("CCC555"));

        when(accountRepository.getSizeAllAccounts()).thenReturn(3L);

        Assertions.assertEquals(accountRepository.getSizeAllAccounts(), accounts.size());
    }

    private void assertTrue(boolean accountExist) {
        Assertions.assertTrue(accountExist);
    }

    private void assertFalse(boolean acc456NUM) {
        Assertions.assertFalse(acc456NUM);
    }
}