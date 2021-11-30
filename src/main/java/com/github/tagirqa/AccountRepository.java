package com.github.tagirqa;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;


public interface AccountRepository {

    public default Set<Account> getAllAccountsByClientId(long l) throws FileNotFoundException {
        return new HashSet<>();
    }
}
