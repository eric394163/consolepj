package controller.login;

import java.util.InputMismatchException;
import java.util.Scanner;

import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class LoginPageImp implements LoginPage {
    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();

    private Login login = new LoginImp();
    private Register register = new RegisterImp();
    private FindID findid = new FindIDImp();
    private FindPW findpw = new FindPWImp();

    private final int EXIT = 0;

    @Override
    public void run() {
        int input = 0;
        // 반복
        do {
            // 메뉴 출력
            System.out.println("============== 로그인 ==============");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 아이디찾기");
            System.out.println("4. 비밀번호찾기");
            System.out.println("0. 뒤로가기");
            System.out.println("====================================");
            System.out.print("입력 :");

            try {
                // 메뉴 선택
                input = sc.nextInt();
                sc.nextLine();
                // 메뉴 실행
                sm.selectMenu(input,
                        () -> login.run(),
                        () -> register.run(),
                        () -> findid.run(),
                        () -> findpw.run());
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);

    }

}
