package homework3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import homework3.InputIncomeExpenseInterface.Transaction;


public class UpdateIncomeExpenseManager implements UpdateIncomeExpenseInterface {
	
		@Override
		public void UpdateIncomeExpenseRun() {
	        Scanner scan = new Scanner(System.in);
	        List<Transaction> transactions = new ArrayList<>();

	        System.out.print("새로운 수입(+)/지출(-): ");
			char type = scan.next().charAt(0);

	        System.out.print("새로운 금액: ");
	        double amount = scan.nextDouble();
	        scan.nextLine(); // 버퍼 비우기

	        System.out.print("새로운 날짜 (yyyy-MM-dd): ");
	        String date = scan.nextLine();

	        System.out.print("새로운 내역 선택: ");
	        String category = scan.nextLine();
	        scan.nextLine(); // 버퍼 비우기
	        
	        //Transaction transaction = new Transaction();
	    }

		@Override
		public void modifyTransaction(Transaction transaction) {
			// TODO Auto-generated method stub
			
		}


		
		
	}
	
      
    

