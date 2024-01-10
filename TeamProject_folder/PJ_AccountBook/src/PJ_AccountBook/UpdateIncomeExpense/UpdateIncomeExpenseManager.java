package PJ_AccountBook.UpdateIncomeExpense;

import java.util.Scanner;

import PJ_AccountBook.AccountBook;
import PJ_AccountBook.IncomeExpense;
import PJ_AccountBook.InputIncomeExpense.InputIncomeExpenseInterface;
import PJ_AccountBook.InputIncomeExpense.InputIncomeExpenseManager;

public class UpdateIncomeExpenseManager implements UpdateIncomeExpenseInterface {

    private static Scanner sc = new Scanner(System.in);

    private AccountBook myAccountBook;
    private InputIncomeExpenseInterface inputIE;

    public UpdateIncomeExpenseManager(AccountBook accountBook) {
        this.myAccountBook = accountBook;
        this.inputIE = new InputIncomeExpenseManager(accountBook);
    }

    public void UpdateIncomeExpenseRun() {

        System.out.println("============ 가계부 수정 ============");
        displayAccountBook();
        
        //여기다가 불러오기 하고
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
            System.out.println("[ 이전 : 1 ]  [ 다음 : 2 ] [ 수정 : 3 ] [ 종료 : 4 ]");
            System.out.println("=====================================================");
            System.out.print("입력 : ");
            input = sc.nextInt();

            if (input == 1 && currentPage > 0) {
                currentPage--;
            } else if (input == 2 && currentPage < totalPages - 1) {
                currentPage++;
            } else if (input == 3) {
                // 수정할 번호를 입력받고 해당하는 인덱스 객체 재 입력
                updateIncomeOrExpense();
            }
        } while (input != 4);
    }

    public void updateIncomeOrExpense() {
        System.out.print("수정할 번호 입력 : ");
        int inputIndexNum = sc.nextInt() - 1;
        int input = 0;
        // 수정할 번호에 해당하는 객체 가져오기
        IncomeExpense updateIndex = myAccountBook.getIncomeExpense(inputIndexNum);
        // 이 객체의 수입 지출 확인 후 1, 2로 input 설정

        if (updateIndex.isIncomeOrExpense() == true) {
            input = 1;
        } else if (updateIndex.isIncomeOrExpense() == false) {
            input = 2;
        }

        // inputSave()로 해당 객체 재 입력
        IncomeExpense incomeExpense = inputIE.inputSave(input);
        // 재 입력한 내용 적용하기 updateIE(index, incomeExpense)
        myAccountBook.updateIncomeExpense(inputIndexNum, incomeExpense);

        System.out.println("수정 완료 ");
        
        //여기다가 저장...?
    }

    // ====================================================================
}