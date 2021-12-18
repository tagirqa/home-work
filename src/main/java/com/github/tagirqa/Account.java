package com.github.tagirqa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class Account {
    private Long id;
    private String number;
    private LocalDate createDate;
    private BigDecimal balance;
    private Long clientId;

    public Account(String number) {
        this.number = number;
    }

    public Account(Long id, String number) {
        this.id = id;
        this.number = number;
    }
}
