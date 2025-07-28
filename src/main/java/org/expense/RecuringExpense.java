package org.expense;

import java.time.LocalDate;

public class RecuringExpense extends Expense {
    ReccurenceType recurence;
    public RecuringExpense(String label, double amount, LocalDate date,ReccurenceType recurence) {
        super(label, amount, date);
        this.recurence = recurence;
    }
    public enum ReccurenceType{
        MONTHLY,
        YEARLY
    }
    @Override
    public String toString() {
        return super.toString() + "Recurrence: " + recurence;
    }
}
