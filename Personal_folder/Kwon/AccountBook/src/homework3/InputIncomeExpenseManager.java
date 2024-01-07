package homework3;

import java.util.Scanner;

//메서드들은 InputIncomeExpenseInterface에 적어두기
public class InputIncomeExpenseManager implements InputIncomeExpenseInterface {
	
	private Scanner scan = new Scanner(System.in);
	private AccountBook ab = new AccountBook();
	
	// 수입지출입력 구현
    @Override
    public void inputIncomeExpenseRun() {
        System.out.println("=========== 수입/지출 추가 ===========");
        System.out.print("날짜를 입력해주세요.(예: 20XX-XX-XX) : ");
        String date = scan.next();
        System.out.println("수입/지출을 입력해주세요.");
        System.out.print("예: 수입이면 +(금액), 지출이면 -(금액) : ");
        long transactionAmount = scan.nextInt();
        System.out.print("내용 : ");
        scan.nextLine();
        String incomeExpenseDetails = scan.nextLine();
        System.out.println("[카테고리 선택]");
        boolean incomeOrExpense = false;
        String category;
        if(transactionAmount > 0) { //수입이면
        	incomeOrExpense = true;
        	System.out.print("용돈(0) 월급(1) : ");
        }else if(transactionAmount < 0) { //지출이면
        	incomeOrExpense = false;
        	System.out.print("식비(3) 교통비(4) 취미(5) 의류(6) 의료/건강(7) : ");
        }
    	category = scan.next();

        IncomeExpense ie = new IncomeExpense(incomeOrExpense, transactionAmount, incomeExpenseDetails, category, date);
        
        if(ab.insertIncomeExpense(ie)) {
			System.out.println("수입/지출을 추가했습니다.");
		}        
        ab.printAccountBook();
    	
    }

}
