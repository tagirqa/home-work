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
    private String currency;

    public Account(String number) {
        this.number = number;
    }

    public Account(Long id, String number) {
        this.id = id;
        this.number = number;
    }

    public Account(BigDecimal balance, String currency, LocalDate createDate) {
        this.createDate = createDate;
        this.balance = balance;
        this.currency = currency;
    }
}
