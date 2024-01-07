package homework3;

import java.util.Scanner;

public class UpdateIncomeExpenseManager implements UpdateIncomeExpenseInterface {

	private Scanner scan = new Scanner(System.in);
	private AccountBook ab = new AccountBook();

    @Override
    public void UpdateIncomeExpenseRun() {
    	System.out.println("============ 가계부 수정 ============");
    	System.out.println("[수정이 필요한 기록을 작성해주세요.]");
    	System.out.print("날짜(예: 20XX-XX-XX) : ");
        String date = scan.next();
    	System.out.println("수입/지출");
        System.out.print("예: 수입이면 +(금액), 지출이면 -(금액) : ");
        long transactionAmount = scan.nextInt();
        System.out.println("카테고리");
        String category;
        boolean incomeOrExpense = false;
        if(transactionAmount > 0) { //수입이면
        	incomeOrExpense = true;
        	System.out.print("용돈(0) 월급(1) : ");
        }else if(transactionAmount < 0) { //지출이면
        	incomeOrExpense = false;
        	System.out.print("식비(3) 교통비(4) 취미(5) 의류(6) 의료/건강(7) : ");
        }
    	category = scan.next();
    	
    	IncomeExpense ie = new IncomeExpense(incomeOrExpense, transactionAmount, "", category, date);
    	
    	if(!ab.checkIncomeExpense(ie)) {
    		System.out.println("기록이 존재하지 않습니다.");
    		return;
    	}
    	
    	
    	
    	System.out.println("----------------------------------");
    	System.out.println("[수정할 기록을 작성해주세요.]");
    	System.out.print("날짜를 입력해주세요.(예: 20XX-XX-XX) : ");
        scan.nextLine();
        date = scan.nextLine();
        System.out.println("수입/지출을 입력해주세요.");
        System.out.print("예: 수입이면 +(금액), 지출이면 -(금액) : ");
        transactionAmount = scan.nextInt();
        System.out.print("내용 : ");
        scan.nextLine();
        String incomeExpenseDetails = scan.nextLine();
        System.out.println("[카테고리 선택]");
        incomeOrExpense = false;
        if(transactionAmount > 0) { //수입이면
        	incomeOrExpense = true;
        	System.out.print("용돈(0) 월급(1) : ");
        }else if(transactionAmount < 0) { //지출이면
        	incomeOrExpense = false;
        	System.out.print("식비(3) 교통비(4) 취미(5) 의류(6) 의료/건강(7) : ");
        }
    	category = scan.next();
        IncomeExpense newie = new IncomeExpense(incomeOrExpense, transactionAmount, incomeExpenseDetails, category, date);
        
        
        ab.updateIncomeExpense(ie, newie);
        ab.printAccountBook();
    	
    }

}
