package homework3;

import java.time.LocalDate;
import java.util.Scanner;

import homework3.InputIncomeExpenseInterface.Transaction;


public abstract class UpdateIncomeExpenseManager implements UpdateIncomeExpenseInterface {

    @Override
    public void UpdateIncomeExpenseRun(int transactionId) {
        Scanner scan = new Scanner(System.in);

        for (Transaction transaction : transactions) {
            if (transaction.getId() == transactionId) {
                System.out.println("현재 내역 정보:");
                //displayTransactionDetails(transaction);

                // 수정할 항목 입력 받기
                System.out.print("수정할 내역을 선택하세요 (1: 날짜, 2: 내역, 3: 수입/지출, 4: 금액): ");
                int choice = scan.nextInt();
                scan.nextLine(); // 개행 문자 제거

                switch (choice) {
                    case 1:
                        // 날짜 수정
                        System.out.print("새로운 날짜를 입력하세요(yyyy-MM-dd): ");
                        String newDateInput = scan.nextLine();
                        LocalDate newDate = LocalDate.parse(newDateInput);
                        transaction.setDate(newDate);
                        break;
                    case 2:
                        // 내역 수정
                        System.out.print("새로운 내역을 입력하세요: ");
                        String newHistory = scan.nextLine();
                        transaction.setHistory(newHistory);
                        break;
                    case 3:
                        // 수입/지출 수정
                        System.out.print("새로운 수입/지출을 입력하세요(+수입/-지출): ");
                        char newType = scan.nextLine().charAt(0);
                        transaction.setType(newType);
                        break;
                    case 4:
                        // 금액 수정
                        System.out.print("새로운 금액을 입력하세요: ");
                        long newAmount = scan.nextLong();
                        scan.nextLine(); 
                        transaction.setAmount(newAmount);
                        break;
                    default:
                        System.out.println("잘못된 선택입니다.");
                        break;
                }

                System.out.println("성공적으로 수정되었습니다.");
                //displayTransactionDetails(transaction);
                return; // 수정이 완료되면 메서드 종료
            }
        }

        System.out.println("해당 ID의 내역이 없습니다.");
    }
}
