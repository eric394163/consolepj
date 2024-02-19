package controller.login;

import java.util.InputMismatchException;
import java.util.Scanner;

import manager.UserManager;
import model.User;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class LoginPageImp implements LoginPage {
    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();

    private Login login;
    private Register register = new RegisterImp();

    private final int EXIT = 0;
    private UserManager uManager;
    private User user;

    public LoginPageImp(UserManager uManager) {
        this.login = new LoginImp(uManager);
        this.uManager = uManager;
        this.user = uManager.getCurrentUser();
    }

    @Override
    public void run() {
        int input = 0;
        // 반복
        do {

            this.user = uManager.getCurrentUser();
            if (user != null && user.isUStatement() == true) {
                break;
            }
            // 메뉴 출력
            System.out.println("=============== 로그인 ================");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("0. 뒤로가기");
            System.out.println("=====================================");
            System.out.print("입력 :");

            try {
                // 메뉴 선택
                input = sc.nextInt();
                if (input == 0) {
                    break;
                }
                sc.nextLine();
                // 메뉴 실행
                sm.selectMenu(input,
                        () -> login.run(),
                        () -> register.run());
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);

    }

}
