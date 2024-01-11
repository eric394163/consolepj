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

    	 System.out.print("삭제할 내역 선택 (번호 입력) 또는 종료(q): ");
         String choice = scan.nextLine();

         if (choice.equalsIgnoreCase("q")) {
             return;
         }

         try {
             int index = Integer.parseInt(choice) - 1;

             if (index < 0 || index >= transactions.size()) {
                 System.out.println("올바른 번호를 입력하세요.");
                 return;
             }

             Transaction deletedTransaction = transactions.remove(index);
             System.out.println("내역이 성공적으로 삭제되었습니다: " + deletedTransaction);
         } catch (NumberFormatException e) {
             System.out.println("숫자를 입력하세요.");
         }
     }


	@Override
	public void deleteTransaction(ArrayList<Transaction> transactions) {
		// TODO Auto-generated method stub
		
	}
 
    }

