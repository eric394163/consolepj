package homework3;

import java.time.LocalDate;

public interface UpdateIncomeExpenseInterface  {

	void UpdateIncomeExpenseRun(int transactionId);
	
	void addTransaction(LocalDate date, String history, char type, long amount);

	void UpdateIncomeExpenseRun();
		
}
    
  