package com.sbrf.reboot.repository;

import com.github.tagirqa.Account;
import com.github.tagirqa.AccountRepository;
import com.github.tagirqa.AccountRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountRepositoryImplTest {

    AccountRepository accountRepository;

    @Test
    void onlyPersonalAccounts() throws IOException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1);
        ArrayList<String> strings = new ArrayList<String>() {{
            add("2-ACCNUM");
            add("1-ACCNUM");
            add("4-ACC1NUM");
        }};

        allAccountsByClientId.forEach(e -> assertTrue(strings.contains(e.getNumber())));
    }

    @Test
    void successGetAllAccountsByClientId() throws IOException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1);

        Assertions.assertEquals(1, (int) allAccountsByClientId.stream().filter(e -> e.getNumber().equals("4-ACC1NUM")).count());
    }

    @Test
    void failGetAllAccountsByClientId() throws IOException {
        accountRepository = new AccountRepositoryImpl("somePath");
        assertThrows(FileNotFoundException.class, () -> {
            accountRepository.getAllAccountsByClientId(1L);
        });
    }


}