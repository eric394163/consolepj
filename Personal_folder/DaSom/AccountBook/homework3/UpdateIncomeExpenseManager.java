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
	        Object transaction;
			transaction.type = scan.nextLine();

	        System.out.print("새로운 금액: ");
	        transaction.amount = scan.nextDouble();
	        scan.nextLine(); // 버퍼 비우기

	        System.out.print("새로운 날짜 (yyyy-MM-dd): ");
	        transaction.date = scan.nextLine();

	        if (transaction.type.equals("+")) {
	            System.out.println("1. 용돈 2. 월급 3. 기타");
	        } else {
	            System.out.println("1. 식비 2. 생활비 3. 의료비 4. 여가생활");
	        }

	        System.out.print("새로운 내역 선택: ");
	        int category = scan.nextInt();
	        scan.nextLine(); // 버퍼 비우기

	        switch (category) {
	            case 1:
	                transaction.description = (transaction.type.equals("+")) ? "용돈" : "식비";
	                break;
	            case 2:
	                transaction.description = (transaction.type.equals("+")) ? "월급" : "생활비";
	                break;
	            case 3:
	                transaction.description = (transaction.type.equals("+")) ? "기타" : "의료비";
	                break;
	            case 4:
	                transaction.description = "여가생활";
	                break;
	            default:
	                System.out.println("올바른 카테고리를 선택하세요.");
	        }
	    }

		@Override
		public void modifyTransaction(Transaction transaction) {
			// TODO Auto-generated method stub
			
		}


		
		
	}
	
      
    

