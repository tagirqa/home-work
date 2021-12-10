package com.github.tagirqa;

import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set getAllAccountsByDateMoreThen(long l, LocalDate minusDays) throws FileNotFoundException {
        return new HashSet<>(accountRepository.getAllAccountsByClientId(l))
                .stream()
                .filter(d -> d.getCreateDate().isAfter(minusDays) || d.getCreateDate().isEqual(minusDays))
                .collect(Collectors.toSet());
    }
}
