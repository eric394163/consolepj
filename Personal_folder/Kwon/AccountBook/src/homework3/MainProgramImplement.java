package homework3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProgramImplement implements MainProgram {

    // 메인 화면 구현 클래스

    private InputIncomeExpenseInterface inputIEManager;
    private UpdateIncomeExpenseInterface UpdateIEManager;
    private DeleteIncomeExpenseInterface DeleteIEManager;

    public MainProgramImplement() {
        this.inputIEManager = new InputIncomeExpenseManager();
        this.UpdateIEManager = new UpdateIncomeExpenseManager();
        this.DeleteIEManager = new DeleteIncomeExpenseManager();
    }

    private static Scanner sc = new Scanner(System.in);

    int EXIT = 5;

    public void run() {
        int inputMainMenu = 0;
        // 반복
        do {
            // 메뉴 출력
            printMainMenu();
            try {
                // 메뉴 선택
                inputMainMenu = sc.nextInt();
                // 메뉴 실행
                runMainMenu(inputMainMenu);
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (inputMainMenu != EXIT);
    }

    @Override
    public void printMainMenu() {
        System.out.println("============== 가계부 ==============");
        System.out.println("1. 수입/지출 추가");
        System.out.println("2. 수입/지출 수정");
        System.out.println("3. 수입/지출 삭제");
        System.out.println("4. (추가기능) ");
        System.out.println("5. 프로그램 종료 ");
        System.out.println("==================================");
        System.out.print("메뉴 선택  :");
    }

    @Override
    public void runMainMenu(int inputMainMenu) {
        switch (inputMainMenu) {
            case 1:
                // 수입 지출 추가
                inputIEManager.inputIncomeExpenseRun();

                break;
            case 2:
                // 가계부 수정
                UpdateIEManager.UpdateIncomeExpenseRun();
                break;
            case 3:
                // 가계부 삭제
                DeleteIEManager.DeleteIncomeExpenseRun();

                break;
            case 4:
                // 추가 기능
                break;
            case 5:
                // 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            default:
                throw new InputMismatchException();
        }
    }
}
