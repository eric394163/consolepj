package homework3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public interface InputIncomeExpenseInterface {

    //InputIncomeExpenseManager에서 구현한 메서드 여기에 적어두기 
	
	void addTransaction(ArrayList<Transaction> transactions);
	
	class Transaction {
	    String type; // 수입("+") 또는 지출("-")
	    double amount; // 금액
	    String date; // 날짜
	    String description; // 내역
	    
	    public Transaction(String type, double amount, String date, String description) {
	        this.type = type;
	        this.amount = amount;
	        this.date = date;
	        this.description = description;
	    }
	}


    void inputIncomeExpenseRun();


}
