package com.github.tagirqa;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Account {
    private Long id;
    private String number;

    public Account(String number) {
        this.number = number;
    }
}
