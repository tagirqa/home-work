package com.github.tagirqa;

import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.NoSuchElementException;

@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public boolean isAccountExist(long l, Account account) throws FileNotFoundException {
        return accountRepository.getAllAccountsByClientId(l).contains(account);
    }

    public Account getMaxAccountBalance(long l) throws FileNotFoundException {

        return accountRepository.getAllAccountsByClientId(l).stream()
                .max(Comparator.comparing(Account::getBalance))
                .orElseThrow(NoSuchElementException::new);
    }
}
