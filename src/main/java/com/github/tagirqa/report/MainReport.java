package com.github.tagirqa.report;

import com.github.tagirqa.Account;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainReport {

    public int getTotalsWithCompletableFuture(Stream<Customer> customerStream) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int sumBalance = 0;
            Set<Customer> customerSet = customerStream
                    .filter(e -> e.getAge() >= 18 && e.getAge() <= 30)
                    .collect(Collectors.toSet());

            for (Customer customer : customerSet) {
                Stream<Account> accountStream = customer.getListAccount().stream();
                sumBalance += accountStream.filter(account -> account.getCreateDate().isAfter(LocalDate.of(2021, 7, 1)) &&
                        account.getCreateDate().isBefore(LocalDate.of(2021, 8, 1)) &&
                        "RUB".equals(account.getCurrency())).mapToInt(v -> v.getBalance().intValue()).sum();
            }
            return sumBalance;
        });
        return future.get();
    }

    public int getTotalsWithReact(Stream<Customer> customerStream) {

        return Flux.fromStream(customerStream)
                .filter(v -> v.getAge() >= 18 && v.getAge() <= 30)
                .flatMapIterable(Customer::getListAccount)
                .toStream()
                .filter(account -> account.getCreateDate().isAfter(LocalDate.of(2021, 7, 1)) &&
                        account.getCreateDate().isBefore(LocalDate.of(2021, 8, 1)) &&
                        "RUB".equals(account.getCurrency()))
                .mapToInt(v -> v.getBalance().intValue())
                .sum();
    }
}
