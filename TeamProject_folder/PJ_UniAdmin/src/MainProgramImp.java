import java.util.InputMismatchException;

import java.util.Scanner;

import courseManage.CourseManage;
import courseManage.CourseManageImp;
import main.MainMenuRun;
import main.MainMenuRunImp;
import model.ManageUni;
import service.print.PrintService;
import service.print.PrintServiceImp;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class MainProgramImp implements MainProgram {

    private ManageUni manageUni;

    private Scanner sc = new Scanner(System.in);
    private PrintService ps;
    private MainMenuRun mr;
    private SelectMenu sm;
    private CourseManage cm;
    private int EXIT = 0;

    // 서비스는 필요할때마다 호출해서 써도 된다. ( 서비스 클래스에는 멤버변수가 없기에 의존성 문제 없음 )
    public MainProgramImp() {

        this.manageUni = new ManageUni();
        this.sm = new SelectMenuImp();
        this.ps = new PrintServiceImp();
        this.cm = new CourseManageImp();
        this.mr = new MainMenuRunImp(manageUni, ps, sm, cm);

    }

    @Override
    public void run() {
        int inputMainMenu = 0;
        // 반복
        do {
            // 메뉴 출력
            ps.printMainMenu();
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
    public void runMainMenu(int inputMainMenu) { //이것도 람다식으로 바꾸기
        switch (inputMainMenu) {
            case 1:
                mr.courseManager();
                break;
            case 2:
                mr.lectureManager();
                break;
            case 3:
                mr.professorManager();
                break;
            case 4:
                mr.studentManager();
                break;
            case 5:
                mr.lectureRegisManager();
                break;
            case 6:
                mr.displayManager();
                break;
            case 7:

                break;
            default:
                throw new InputMismatchException();
        }

    }

}
