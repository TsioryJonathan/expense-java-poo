package org.expense;

import java.time.LocalDate;

public class RefundableExpense extends Expense {
    boolean refunded = false;

    public RefundableExpense(String label, double amount, LocalDate date) {
        super(label, amount, date);
    }

    public void refund(){
        this.refunded = true;
    }

    public boolean isRefunded(){
        return this.refunded;
    }
}
