package homework3;

import java.util.List;
import java.util.Scanner;

public class DeleteIncomeExpenseManager implements DeleteIncomeExpenseInterface {
	private Scanner scan = new Scanner(System.in);
	//private AccountBook ab = new AccountBook();
	private List<IncomeExpense> IncomeExpense;
	
	public DeleteIncomeExpenseManager(List<IncomeExpense> IncomeExpense) {
		if(IncomeExpense == null) {
			return;
		}
		this.IncomeExpense = IncomeExpense;
	}

    @Override
    public void DeleteIncomeExpenseRun() {
    	AccountBook ab = new AccountBook(IncomeExpense);
    	System.out.println("============ 가계부 삭제 ============");
    	System.out.println("[삭제할 기록을 작성해주세요.]");
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
    	
    	IncomeExpense ie = new IncomeExpense(category, date, transactionAmount);
    
    	ab.deleteIncomeExpense(ie);
    }

}
