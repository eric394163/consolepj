package homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import homework3.InputIncomeExpenseInterface.Transaction;

public class DeleteIncomeExpenseManager implements DeleteIncomeExpenseInterface {
	
	static Scanner scan = new Scanner(System.in);
	List<Transaction> transactions = new ArrayList<>();

    @Override
    public void DeleteIncomeExpenseRun() {
    	
    	//가계부가 비어있으면 출력
    	 if(transactions.isEmpty()) {
    	        System.out.println("삭제할 거래가 없습니다.");
    	        return;
    	    }
    	 
    	 System.out.println("===== 가계부 내역 =====");
    	    for (Transaction transaction : transactions) {
    	        System.out.println("ID: " + transaction.getId() +
    	                           ", 날짜: " + transaction.date +
    	                           ", 내역: " + transaction.history +
    	                           ", 수입/지출: " + (transaction.type == '+' ? "수입" : "지출") +
    	                           ", 금액: " + transaction.amount);
    	    }
    	    System.out.println("=======================");

    	    System.out.print("삭제할 거래의 ID를 입력하세요: ");
    	    int deleteId = scan.nextInt();
    	    scan.nextLine();
    	 
    	 
    	 

    }

}
