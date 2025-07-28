package expense;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.expense.Expense;
import org.expense.ExpenseDAO;
import org.expense.RecuringExpense;
import org.expense.RefundableExpense;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class expenseDAOTest {
    RefundableExpense refundableExpenseNotRefunded;
    RefundableExpense refundableExpenseRefunded;

    RecuringExpense recurringExpenseMonthly;
    RecuringExpense recurringExpenseYearly;

    Expense normalExpense1;

    ExpenseDAO expenseDAO = new ExpenseDAO();

    @BeforeEach
    void setup(){
        /* Not refunded */
        this.refundableExpenseNotRefunded = new RefundableExpense("Doctor Consultation", 200, LocalDate.now());

        /* Refunded */
        this.refundableExpenseRefunded = new RefundableExpense("Car Rental", 60, LocalDate.now());
        refundableExpenseRefunded.refund();

        /* Recurring Monthly */
        this.recurringExpenseMonthly = new RecuringExpense("Electricity Bill", 120, LocalDate.now(), RecuringExpense.ReccurenceType.MONTHLY);

        /* Recurring Yearly */
        this.recurringExpenseYearly = new RecuringExpense("Internet Bill", 95, LocalDate.now(), RecuringExpense.ReccurenceType.YEARLY);

        /* Normal Expense */
        this.normalExpense1 = new Expense("Food", 80, LocalDate.now());

        /* Adding to the List of Expenses*/
        expenseDAO.addExpense(refundableExpenseNotRefunded);
        expenseDAO.addExpense(refundableExpenseRefunded);

        expenseDAO.addExpense(recurringExpenseMonthly);
        expenseDAO.addExpense(recurringExpenseYearly);

        expenseDAO.addExpense(normalExpense1);
    }

    @Test

    void check_if_expense_is_large(){
        Assertions.assertTrue(recurringExpenseMonthly.isLargeExpense());
        Assertions.assertFalse(normalExpense1.isLargeExpense());
    }
    @Test
    void get_expense_not_refunded_test(){
        List<Expense> not_refunded_list = new ArrayList<>();
        not_refunded_list.add(refundableExpenseNotRefunded);

        Assertions.assertEquals(not_refunded_list, expenseDAO.getExpenseNotRefunded());
    }

    @Test
    void get_total_amount_of_recurring_expense_test(){
        Assertions.assertEquals(215, expenseDAO.getTotalAmountRecurringExpenses());
    }

    @Test
    void get_label_of_expense_over_hundred_test(){
        List<String> label_list = new ArrayList<>();
        label_list.add("Doctor Consultation");
        label_list.add("Electricity Bill");

        Assertions.assertEquals(label_list , expenseDAO.getLabelsOfExpensesOverHundred());
    }

    @Test
    void get_total_amount_of_expenses_test(){
        Assertions.assertEquals(555, expenseDAO.getTotalAmountExpenses());
    }
}
