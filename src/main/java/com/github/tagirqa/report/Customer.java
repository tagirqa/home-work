package com.github.tagirqa.report;

import com.github.tagirqa.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class Customer {
    private int age;
    private String name;
    private List<Account> listAccount;
}
