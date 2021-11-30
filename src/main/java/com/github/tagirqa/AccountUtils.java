package com.github.tagirqa;

import java.util.Comparator;
import java.util.List;

public class AccountUtils {


    public static void sortedByIdDate(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId).thenComparing(Account::getCreateDate));
    }

    public static void sortedByBalance(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId)
                .thenComparing(Account::getCreateDate)
                .thenComparing(Account::getBalance));
    }

    public static void sortedById(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId));
    }
}
