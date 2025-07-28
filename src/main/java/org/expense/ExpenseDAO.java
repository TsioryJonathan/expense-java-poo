package org.expense;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseDAO {
    List<Expense> expenses = new ArrayList<>();
    public List<Expense> getExpenseNotRefunded(){
       return expenses.stream()
                .filter((expense) -> expense instanceof RefundableExpense)
                .filter((expense) -> !((RefundableExpense) expense).isRefunded())
                .toList();
    }

    public float getTotalAmountRecurringExpenses(){
        return (float) expenses.stream()
                .filter((expense) -> expense instanceof RecuringExpense)
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public List<String> getLabelsOfExpensesOverHundred(){
        return expenses.stream()
                .filter(Expense::isLargeExpense)
                .map(Expense::getLabel)
                .collect(Collectors.toList());
    }

    public float getTotalAmountExpenses(){
        return (float) expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public void addExpense(Expense expense){
        expenses.add(expense);
    }
}
