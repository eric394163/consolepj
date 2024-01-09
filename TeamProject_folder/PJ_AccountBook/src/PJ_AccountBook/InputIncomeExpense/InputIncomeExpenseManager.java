package PJ_AccountBook.InputIncomeExpense;

import java.util.Scanner;
import java.util.regex.Pattern;

import PJ_AccountBook.AccountBook;
import PJ_AccountBook.ExpenseCategory;
import PJ_AccountBook.IncomeCategory;
import PJ_AccountBook.IncomeExpense;

public class InputIncomeExpenseManager implements InputIncomeExpenseInterface {

    private AccountBook myAccountBook;

    public InputIncomeExpenseManager(AccountBook accountBook) {
        this.myAccountBook = accountBook;
    }

    private static Scanner sc = new Scanner(System.in);

    @Override
    public void inputIncomeExpenseRun() { ㅓㅏㅗㅓㅏㅗㅓㅏㅓㅘㅗㅓㅏㅗㅓㅓㅗ

        System.out.println("===== 가계부 작성 =====");
        System.out.print("수입 (1) / 지출 (2) :");
        int input = sc.nextInt();

        IncomeExpense incomeExpense = inputSave(input);

        myAccountBook.addIncomeOrExpense(incomeExpense);

        myAccountBook.printAllIncomeExpenses();
    }

    public IncomeExpense inputSave(int input) {
        sc.nextLine();

        // 날짜 입력
        String inputDate = "";
        String datePattern = "\\d{4}\\.\\d{2}\\.\\d{2}"; // YYYY.MM.DD 정규 표현식
        while (true) {
            System.out.print("날짜 [ 예 : 2024.01.01 ] : ");
            inputDate = sc.nextLine();

            if (Pattern.matches(datePattern, inputDate)) {
                break;
            } else {
                System.out.println("다시 입력 하세요");
            }
        }
        String[] splitDate = inputDate.split("\\.");
        String monthString = "";
        String yearString = "";
        String dayString = "";

        monthString = splitDate[1];

        dayString = splitDate[2];

        yearString = splitDate[0];

        int month = Integer.parseInt(monthString);
        int day = Integer.parseInt(dayString);
        int year = Integer.parseInt(yearString);

        // 내용 입력
        System.out.print("내용 :");
        String inputDetail = sc.nextLine();

        // 금액 입력
        System.out.print("금액 :");
        Long inputAmount = (long) 0;
        while (true) {
            inputAmount = sc.nextLong();
            if (inputAmount != 0) {
                break;
            } else {
                System.out.println("다시 입력");
            }
        }
        sc.nextLine();

        // 수입 처리
        if (input == 1) {
            System.out.println("==============");
            for (IncomeCategory category : IncomeCategory.values()) {
                System.out.println(category);
            }
            System.out.println("==============");
            System.out.print("분류 : ");
            String userInputIncomeCategory = sc.nextLine();
            IncomeCategory inputIncomeCategory = null;
            try {
                inputIncomeCategory = IncomeCategory.valueOf(userInputIncomeCategory.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 분류 입력");
            }

            IncomeExpense incomeExpense = new IncomeExpense(true, inputAmount, inputDetail, inputIncomeCategory.name(),
                    inputDate,
                    month, year, day);

            System.out.println("입력 완료");
            return incomeExpense;

        }

        // 지출 처리
        if (input == 2) {
            System.out.println("==============");
            for (ExpenseCategory category : ExpenseCategory.values()) {
                System.out.println(category);
            }
            System.out.println("==============");
            System.out.print("분류 : ");
            String userInputExpesneCategory = sc.nextLine();
            ExpenseCategory inputExpenseCategory = null;
            try { // valueOf 메서드 확인
                inputExpenseCategory = ExpenseCategory.valueOf(userInputExpesneCategory.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 분류 입력");
            }

            IncomeExpense incomeExpense = new IncomeExpense(false, inputAmount, inputDetail,
                    inputExpenseCategory.name(), inputDate,
                    month, year, year);

            System.out.println("입력 완료");

            return incomeExpense;

        }
        return null;

    }
}
