package PJ_AccountBook.DisplayAccountBook;

import java.util.Scanner;

import PJ_AccountBook.AccountBook;

public class DisplayAccountBookManager implements DisplayAccountBookInterface {
    private AccountBook myAccountBook;

    private Scanner sc = new Scanner(System.in);

    public DisplayAccountBookManager(AccountBook accountBook) {
        this.myAccountBook = accountBook;
    }

    @Override
    public void DisplayAccountBookRun() {
    	int menu=0;
    	System.out.println("============= 추가기능 =============");
        System.out.println("1. 총 수입/지출 ");
        System.out.println("2. 가계부 수정 ");
        System.out.println("==================================");
        System.out.print("메뉴 선택  :");
        menu = sc.nextInt();
        sc.nextLine();
        switch(menu) {
        case 1:
        	printTotalIE();
        	break;
        case 2:
        	printDateQuery();
        	break;
        default:
        	System.out.println("잘못된 메뉴입니다.");
        }
    }

	@Override
	public void printTotalIE() {
		// 총 수입지출 출력
		myAccountBook.printTotalIE();
	}

	@Override
	public void printDateQuery() {
		int i;
		System.out.print("원하는 날짜 범위를 입력하세요 (예: 2023.12 or 2023.11.30): ");
		String enter = sc.next();
		myAccountBook.dateQuery(enter);
	}

    

}
