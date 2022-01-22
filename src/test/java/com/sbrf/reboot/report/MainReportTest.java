package com.sbrf.reboot.report;

import com.github.tagirqa.Account;
import com.github.tagirqa.report.Customer;
import com.github.tagirqa.report.MainReport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class MainReportTest {
    @Test
    void getTotalsWithCompletableFutureTest() throws ExecutionException, InterruptedException {
        List<Account> accountsFirst = new ArrayList<Account>() {{
            add(new Account(BigDecimal.TEN, "RUB", LocalDate.now().minusMonths(6)));
            add(new Account(BigDecimal.ONE, "RUB", LocalDate.now().minusMonths(6)));
            add(new Account(BigDecimal.valueOf(33), "RUB", LocalDate.now().minusMonths(6)));
            add(new Account(BigDecimal.TEN, "RUB", LocalDate.now()));
        }};

        List<Account> accountsSecond = new ArrayList<Account>() {{
            add(new Account(BigDecimal.TEN, "RUB", LocalDate.now().minusMonths(6)));
        }};

        Customer customerIvan = new Customer(27, "Ivan", accountsFirst);
        Customer customerSvetlana = new Customer(31, "Svetlana", accountsSecond);
        List<Customer> list = new ArrayList<>();
        list.add(customerIvan);
        list.add(customerSvetlana);

        Assertions.assertEquals(44, new MainReport().getTotalsWithCompletableFuture(list.stream()));
    }

    @Test
    void getTotalsWithReact() {
        List<Account> accountsFirst = new ArrayList<Account>() {{
            add(new Account(BigDecimal.TEN, "RUB", LocalDate.now().minusMonths(6)));
            add(new Account(BigDecimal.ONE, "RUB", LocalDate.now().minusMonths(6)));
            add(new Account(BigDecimal.valueOf(33), "RUB", LocalDate.now().minusMonths(6)));
            add(new Account(BigDecimal.TEN, "RUB", LocalDate.now()));
        }};

        List<Account> accountsSecond = new ArrayList<Account>() {{
            add(new Account(BigDecimal.TEN, "RUB", LocalDate.now().minusMonths(6)));
        }};

        Customer customerIvan = new Customer(27, "Ivan", accountsFirst);
        Customer customerSvetlana = new Customer(31, "Svetlana", accountsSecond);
        List<Customer> list = new ArrayList<>();
        list.add(customerIvan);
        list.add(customerSvetlana);

        Assertions.assertEquals(44, new MainReport().getTotalsWithReact(list.stream()));
    }
}
