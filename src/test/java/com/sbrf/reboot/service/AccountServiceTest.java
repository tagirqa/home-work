package com.sbrf.reboot.service;

import com.github.tagirqa.Account;
import com.github.tagirqa.AccountRepository;
import com.github.tagirqa.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
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

    @SneakyThrows
    @Test
    void getMaxAccountBalance() {
        Account accountWithMaxBalance = Account.builder().clientId(1L).id(4L).balance(new BigDecimal(150000)).build();
        Set<Account> accounts = new HashSet() {{
            add(Account.builder().clientId(1L).id(1L).balance(BigDecimal.TEN).build());
            add(Account.builder().clientId(1L).id(2L).balance(new BigDecimal(200)).build());
            add(Account.builder().clientId(1L).id(3L).balance(new BigDecimal("1.65")).build());
            add(accountWithMaxBalance);
        }};

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertEquals(accountWithMaxBalance, accountService.getMaxAccountBalance(1L));
    }


    @SneakyThrows
    @Test
    void getAllAccountsByDateMoreThen() {
        Account account1 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(2))
                .build();
        Account account2 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(3))
                .build();
        Account account3 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(1))
                .build();
        Account account4 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(7))
                .build();

        Set<Account> accounts = new HashSet() {{
            add(account1);
            add(account2);
            add(account3);
            add(account4);
        }};

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        Set allAccountsByDateMoreThen = accountService.getAllAccountsByDateMoreThen(1L, LocalDate.now().minusDays(2));

        assertEquals(2, allAccountsByDateMoreThen.size());
        assertTrue(allAccountsByDateMoreThen.contains(account3));
    }

}