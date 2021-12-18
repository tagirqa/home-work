package com.github.tagirqa;

import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
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

    /**
     * Сортирует по дате создания начиная от самого свежего
     * Если дата создания одинаковая, тогда по убыванию баланса
     *
     * @throws FileNotFoundException
     */
    public List<Account> getSortedDateAndBalance(long l) throws FileNotFoundException {
        return new ArrayList<>(accountRepository.getAllAccountsByClientId(l)).stream()
                .sorted(Comparator.comparing(Account::getCreateDate)
                        .thenComparing(Account::getBalance)
                        .reversed())
                .collect(Collectors.toList());
    }
}
