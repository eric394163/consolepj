package homework3;

import java.util.ArrayList;

import homework3.InputIncomeExpenseInterface.Transaction;

public interface DeleteIncomeExpenseInterface {
    void DeleteIncomeExpenseRun();
    void deleteTransaction(ArrayList<Transaction> transactions);
}
