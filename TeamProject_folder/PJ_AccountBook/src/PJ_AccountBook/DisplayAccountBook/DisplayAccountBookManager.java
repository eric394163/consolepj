package PJ_AccountBook.DisplayAccountBook;

import java.util.InputMismatchException;
import java.util.Scanner;

import PJ_AccountBook.AccountBook;

public class DisplayAccountBookManager implements DisplayAccountBookInterface {
    private AccountBook myAccountBook;
    private int EXIT = 4;

    private Scanner sc = new Scanner(System.in);

    public DisplayAccountBookManager(AccountBook accountBook) {
        this.myAccountBook = accountBook;
    }

    // =======================================================================================================================================

    //
    @Override
    public void displayAccountBookMainRun() {
        displayAccountBookRun();
    }

    private void displayAccountBookRun() {
        int input = 0;
        // 반복
        do {
            // 메뉴 출력
            printDisplayABMenu();
            try {
                // 메뉴 선택
                input = sc.nextInt();
                // 메뉴 실행
                runDisplayACBookMenu(input);
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);
    }

    private void printDisplayABMenu() {
        System.out.println("====== 가계부 ======");
        System.out.println("1. 전체 ");
        System.out.println("2. 날짜별 검색 ");
        System.out.println("3. 총 수입/지출 ");
        System.out.println("4. 이전으로 ");
        System.out.println("===================");
        System.out.print("입력 :");
    }

    private void runDisplayACBookMenu(int input) {

        switch (input) {
            case 1:
                // 전체 출력
                displayAll();

                break;
            case 2:
                // 월별 검색 출력
                searchMonthAnddisplay();

                break;

            case 3:
                // 총 수입/지출 출력
                printTotalIE();

                break;
            case 4:

                break;

            default:
                break;
        }
    }

    private void displayAll() {
        int input = 0;
        int currentPage = 0;
        final int pageSize = 5; // 한 페이지에 들어갈 항목 수
        int totalPages = (myAccountBook.getAccountBookSize() + pageSize - 1) / pageSize; // 총 페이지 수 계산

        do {
            System.out.println("======= 가계부 (페이지 " + (currentPage + 1) + " / " + totalPages
                    + ") ==========");
            myAccountBook.printIncomeExpense(currentPage * pageSize, pageSize);

            System.out.println("===================================");
            System.out.println("[ 이전 : 1 ]  [ 다음 : 2 ] [ 종료 : 3 ]");
            System.out.println("===================================");
            System.out.print("입력 : ");
            input = sc.nextInt();

            if (input == 1 && currentPage > 0) {
                currentPage--;
            } else if (input == 2 && currentPage < totalPages - 1) {
                currentPage++;
            }
        } while (input != 3);

    }

    private void printTotalIE() {
        // 총 수입지출 출력
        myAccountBook.printTotalIE();
    }

    private void searchMonthAnddisplay() { // 날짜별 검색(모든 날짜)
        System.out.print("원하는 날짜 범위를 입력하세요 (예: 2023.12 or 2023.11.30): ");
        String enter = sc.next();
        myAccountBook.dateQuery(enter);
    }

}
