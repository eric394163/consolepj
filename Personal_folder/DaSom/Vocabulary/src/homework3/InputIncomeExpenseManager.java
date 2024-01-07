package homework3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputIncomeExpenseManager implements InputIncomeExpenseInterface {

	static Scanner scan = new Scanner(System.in);
	List<Transaction> transactions = new ArrayList<>(); //내역 저장 리스트
	
    @Override
    public void inputIncomeExpenseRun() {
        // 수입지출입력 구현
        // 메서드들은 InputIncomeExpenseInterface에 적어두기
    	
    	//long으로 금액지정
    	long amount;
    	int balance = 0; //현재 잔액
    	
    	while(true) {
    		
    	//수입과 지출을 입력
    	System.out.print("수입 또는 지출을 입력(+수입/-지출/e종료) : ");
    	char type = scan.nextLine().charAt(0);
    	
    	//종료 입력시 종료
    	if (type == 'e') {
            System.out.println("가계부로 돌아갑니다.");
            break;
        }
    	
    	//입력값에 +나 -가 없으면 다시 입력받기
    	if (type != '+' && type != '-') {
            System.out.println("잘 못 된 입력입니다. + 혹은 -로 입력 해주세요.");
            continue;
        }
    	
    	
    	//+나 - 입력 받으면 금액을 입력 받기
    	System.out.print("금액을 입력하세요 : ");
    	amount = scan.nextLong();
    	scan.nextLine();
    	
    	//날짜 입력 받기
    	System.out.print("날짜를 입력하세요(yyyy-MM-dd): ");
    	String dateInput = scan.nextLine();
        LocalDate date = LocalDate.parse(dateInput);
    	
    	//내역 입력 받기
    	System.out.print("내역을 입력하세요 : ");
    	String history = scan.nextLine();
    	

    	//+일시 수입 -일시 지출
    	 if (type == '+') {
             // 현재금액에 금액 추가
             balance += amount;
             System.out.println("수입이 추가 됐습니다.");
         } else {
             // 현재금액에 금액 빼기
             balance -= amount;
             System.out.println("지출이 추가 됐습니다.");
         }
    	
    	//객체 생성
    	Transaction transaction = new Transaction(date, history, type, amount);
    	//리스트에 추가
    	transactions.add(transaction);
    	
    	//현재 잔액 알려주기
    	System.out.println("현재 잔액: " + balance);
    	//가계부 번호
    	System.out.println("가계부 번호 (ID: " + transaction.getId() + ")");
    	System.out.println("----------------------");
    	}
    }
}
