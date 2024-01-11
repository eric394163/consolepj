package PJ_AccountBook;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import PJ_AccountBook.DeleteIncomeExpense.DeleteIncomeExpenseInterface;
import PJ_AccountBook.DeleteIncomeExpense.DeleteIncomeExpenseManager;
import PJ_AccountBook.DisplayAccountBook.DisplayAccountBookInterface;
import PJ_AccountBook.DisplayAccountBook.DisplayAccountBookManager;
import PJ_AccountBook.InputIncomeExpense.InputIncomeExpenseInterface;
import PJ_AccountBook.InputIncomeExpense.InputIncomeExpenseManager;
import PJ_AccountBook.UpdateIncomeExpense.UpdateIncomeExpenseInterface;
import PJ_AccountBook.UpdateIncomeExpense.UpdateIncomeExpenseManager;
import PJ_AccountBook.service.FileService;
import PJ_AccountBook.service.FileServiceImp;


public class MainProgramImplement implements MainProgram {

    // 메인 화면 구현 클래스

    private AccountBook myAccountBook;
    private InputIncomeExpenseInterface InputIEManager;
    private UpdateIncomeExpenseInterface UpdateIEManager;
    private DeleteIncomeExpenseInterface DeleteIEManager;
    private DisplayAccountBookInterface DisplayACManager;
    
    private FileService fileService = new FileServiceImp();
    private String fileName = "src/PJ_AccountBook/accountBookList.txt";
    

    public MainProgramImplement() {
        this.myAccountBook = new AccountBook();
		
		//불러오기
		List<IncomeExpense> list = fileService.load(fileName);
		
		myAccountBook = new AccountBook(list);
        
        this.InputIEManager = new InputIncomeExpenseManager(myAccountBook);
        this.UpdateIEManager = new UpdateIncomeExpenseManager(myAccountBook);
        this.DeleteIEManager = new DeleteIncomeExpenseManager(myAccountBook);
        this.DisplayACManager = new DisplayAccountBookManager(myAccountBook);
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
        
        //저장하기
  		if(fileService.save(fileName, myAccountBook.getIncomeExpense())) {
  			System.out.println("저장이 완료되었습니다.");
  		}else {
  			System.out.println("저장에 실패했습니다.");
  		}
    }

    @Override
    public void printMainMenu() {
        System.out.println("============= 가계부 =============");
        System.out.println("1. 가계부 작성 ");
        System.out.println("2. 가계부 수정 ");
        System.out.println("3. 가계부 삭제 ");
        System.out.println("4. 가계부 조회 ");
        System.out.println("5. 가계부 종료 ");
        System.out.println("==================================");
        System.out.print("메뉴 선택  :");
    }

    @Override
    public void runMainMenu(int inputMainMenu) {
        switch (inputMainMenu) {
            case 1:
                // 수입 지출 추가
                InputIEManager.inputIncomeExpenseRun();

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
                // 가계부 출력
                DisplayACManager.displayAccountBookMainRun();
                break;
            case 5:
                // 프로그램 종료
                System.out.println("프로그램 종료.");
                break;
            default:
                throw new InputMismatchException();
        }
    }
}
