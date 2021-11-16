package com.github.tagirqa;

import java.util.HashSet;
import java.util.Set;


public class AccountRepository implements AccountInterface {

    @Override
    public Set<Account> getAllAccountsByClientId(long l) {
        return new HashSet<>();
    }

    @Override
    public Long getSizeAllAccounts() {
        return null;
    }

}
