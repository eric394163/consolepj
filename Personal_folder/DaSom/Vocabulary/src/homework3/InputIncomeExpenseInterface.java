package homework3;

import java.time.LocalDate;
import java.util.Scanner;

public interface InputIncomeExpenseInterface {

    //InputIncomeExpenseManager에서 구현한 메서드 여기에 적어두기 
	
	class Transaction {
		private static int idCounter = 1;
		private int id;
		LocalDate date;//날짜
	    String history;//내역
	    char type; // 수익지출
	    long amount;//금액

	    public Transaction(LocalDate date, String history, char type, long amount) {
	        this.id = idCounter++;
	        this.date = date;
	        this.history = history;
	        this.type = type;
	        this.amount = amount;
	    }
	    
	    public int getId() {
	        return id;
	    }

		public static int getIdCounter() {
			return idCounter;
		}

		public static void setIdCounter(int idCounter) {
			Transaction.idCounter = idCounter;
		}

		public String getHistory() {
			return history;
		}

		public void setHistory(String history) {
			this.history = history;
		}

		public char getType() {
			return type;
		}

		public void setType(char type) {
			this.type = type;
		}

		public long getAmount() {
			return amount;
		}

		public void setAmount(long amount) {
			this.amount = amount;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setDate(LocalDate newDate) {
			// TODO Auto-generated method stub
			
		}
	}

    void inputIncomeExpenseRun();

    

}
