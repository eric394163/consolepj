package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.admin.BoardManagePage;
import controller.admin.BoardManagePageImp;
import controller.admin.CategoryManagePage;
import controller.admin.CategoryManagePageImp;
import controller.admin.UserManagePage;
import controller.admin.UserManagePageImp;
import controller.board.BoardPage;
import controller.board.BoardPageImp;
import controller.login.LoginPage;
import controller.login.LoginPageImp;
import controller.mypage.MyPage;
import controller.mypage.MyPageImp;
import manager.UserManager;
import model.User;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class MainProgramImp implements MainProgram {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();

    private LoginPage loginpage;
    private BoardPage board;
    private MyPage mypage;
    private UserManager uManager;
    private CategoryManagePage cmPage = new CategoryManagePageImp();
    private BoardManagePage bmPage = new BoardManagePageImp();
    private UserManagePage umPage = new UserManagePageImp();

    private User user;

    private final int EXIT = 0;

    public MainProgramImp() {
        this.uManager = new UserManager();
        this.mypage = new MyPageImp(uManager);
        this.board = new BoardPageImp(uManager);
        this.loginpage = new LoginPageImp(uManager);
    }

    @Override
    public void mainRun() {
        user = uManager.getCurrentUser();
        int input = 0;
        // 반복
        do {

            if (user != null && user.getUAdmin() == 1) {
                printAdminMenu();
            } else {

                printUserMenu();
            }

            try {
                // 메뉴 선택
                input = sc.nextInt();

                if (user != null && user.getUAdmin() == 1) {

                    sm.selectMenu(input,
                            () -> cmPage.run(),
                            () -> bmPage.run(),
                            () -> umPage.run());

                } else {
                    sm.selectMenu(input,
                            () -> loginpage.run(),
                            () -> board.run(),
                            () -> mypage.run()); // 로그아웃 메서드 추가

                }

            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);

    }

    private void printAdminMenu() {
        System.out.println("========== 게시판 프로그램 ==========");
        System.out.println("1. 카테고리 관리");
        System.out.println("2. 게시판 관리"); // 해당 게시판에서 공시사항 작성하기
        System.out.println("3. 회원 관리");
        System.out.println("4. 로그아웃");
        System.out.println("0. 프로그램 종료");
        System.out.println("====================================");
        System.out.print("입력 :");
    }

    private void printUserMenu() {
        System.out.println("============ 관리자 메뉴 ============");
        System.out.println("1. 로그인");
        System.out.println("2. 게시판");
        System.out.println("3. 마이페이지");
        System.out.println("4. 로그아웃");
        System.out.println("0. 프로그램 종료");
        System.out.println("====================================");
        System.out.print("입력 :");
    }

}
