package org.spockworkshop.domain;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public BigDecimal balance() {
        return balance;
    }
}
