package homework3;

import java.util.ArrayList;
import java.util.Scanner;

public class InputIncomeExpenseManager implements InputIncomeExpenseInterface {

	
	@Override
	public void inputIncomeExpenseRun() {
	
	// @Override
	    //public void addTransaction(ArrayList<Transaction> transactions) {
	        Scanner scan = new Scanner(System.in);

	        System.out.println("=== 가계부 추가 ===");

	        System.out.print("수입(+) 또는 지출(-) 입력: ");
	        String type = scan.nextLine();

	        System.out.print("금액 입력: ");
	        double amount = scan.nextDouble();
	        scan.nextLine(); // 버퍼 비우기

	        System.out.print("날짜 입력 (yyyy-MM-dd): ");
	        String date = scan.nextLine();

	        if (type.equals("+")) {
	            System.out.println("1. 용돈 2. 월급 3. 기타");
	        } else {
	            System.out.println("1. 식비 2. 생활비 3. 의료비 4. 여가생활");
	        }

	        System.out.print("내역 선택: ");
	        int category = scan.nextInt();
	        scan.nextLine(); // 버퍼 비우기

	        String description;
	        switch (category) {
	            case 1:
	                description = (type.equals("+")) ? "용돈" : "식비";
	                break;
	            case 2:
	                description = (type.equals("+")) ? "월급" : "생활비";
	                break;
	            case 3:
	                description = (type.equals("+")) ? "기타" : "의료비";
	                break;
	            case 4:
	                description = "여가생활";
	                break;
	            default:
	                System.out.println("올바른 카테고리를 선택하세요.");
	                return;
	        }

	        Transaction newTransaction = new Transaction(type, amount, date, description);
	        ArrayList<Transaction> transactions = new ArrayList<>();
			//transactions.add(newTransaction);

	        System.out.println("새로운 내역이 성공적으로 추가되었습니다.");
	    }

	@Override
	public void addTransaction(ArrayList<Transaction> transactions) {
		// TODO Auto-generated method stub
		
	}
	}
		
	//}

