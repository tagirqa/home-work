package com.github.tagirqa;

import java.util.Set;

public interface AccountInterface {
    Set<Account> getAllAccountsByClientId(long l);

    Long getSizeAllAccounts();
}
