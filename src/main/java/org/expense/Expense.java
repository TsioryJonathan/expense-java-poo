package org.expense;

import java.time.LocalDate;

public class Expense {
    private final String label;
    private final double amount;
    LocalDate date;

    public Expense(String label, double amount, LocalDate date) {
        this.label = label;
        this.amount = amount;
        this.date = date;
    }

    public String getLabel() {
        return label;
    }
    public double getAmount() {
        return amount;
    }

    public boolean isLargeExpense(){
        return this.amount > 100.0;
    }

    @Override
    public String toString() {
        return "Expense label: " + label + " amount: " + amount + " date: " + date;
    }
}
