package PJ_AccountBook.DeleteIncomeExpense;

import java.util.Scanner;

import PJ_AccountBook.AccountBook;

public class DeleteIncomeExpenseManager implements DeleteIncomeExpenseInterface {

    private AccountBook myAccountBook;

    private Scanner sc = new Scanner(System.in);

    public DeleteIncomeExpenseManager(AccountBook accountBook) {
        this.myAccountBook = accountBook;
    }

    @Override
    public void DeleteIncomeExpenseRun() {
        System.out.println("================= 가계부 삭제 ================");
        displayAccountBook();

    }

    public void displayAccountBook() {
        int input = 0;
        int currentPage = 0;
        final int pageSize = 5; // 한 페이지에 들어갈 항목 수
        int totalPages = (myAccountBook.getAccountBookSize() + pageSize - 1) / pageSize; // 총 페이지 수 계산

        do {
            System.out.println("======= 가계부 (페이지 " + (currentPage + 1) + " / " + totalPages
                    + ") ==========");
            myAccountBook.printIncomeExpense(currentPage * pageSize, pageSize);

            System.out.println("=====================================================");
            System.out.println("[ 이전 : 1 ]  [ 다음 : 2 ] [ 삭제 : 3 ] [ 종료 : 4 ]");
            System.out.println("=====================================================");
            System.out.print("입력 : ");
            input = sc.nextInt();

            if (input == 1 && currentPage > 0) {
                currentPage--;
            } else if (input == 2 && currentPage < totalPages - 1) {
                currentPage++;
            } else if (input == 3) {
                // 삭제할 번호를 입력받고 해당하는 인덱스 객체 재 입력
                deleteIncomeOrExpense();
            }
        } while (input != 4);
    }

    public void deleteIncomeOrExpense() {
        System.out.print("수정할 번호 입력 : ");
        int inputIndexNum = sc.nextInt() - 1;

        // 삭제할 번호에 해당하는 객체 가져오기
        int deleteIndex = myAccountBook.getIncomeExpenseIndex(inputIndexNum);

        if (deleteIndex != -1) {
            myAccountBook.deleteIncomeExpense(deleteIndex);
        } else {
            System.out.println("삭제 실패");
        }

        System.out.println("수정 완료 ");
    }

}
