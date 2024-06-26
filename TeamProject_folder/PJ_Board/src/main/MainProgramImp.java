package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.admin.BoardManagePage;
import controller.admin.BoardManagePageImp;
import controller.admin.CategoryManagePage;
import controller.admin.CategoryManagePageImp;
import controller.admin.UserManagePage;
import controller.admin.UserManagePageImp;
import controller.board.BoardListPage;
import controller.board.BoardListPageImp;
import controller.login.LoginPage;
import controller.login.LoginPageImp;
import controller.mypage.MyPage;
import controller.mypage.MyPageImp;
import manager.UserManager;
import model.User;
import service.login.LogoutService;
import service.login.LogoutServiceImp;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class MainProgramImp implements MainProgram {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();

    private LoginPage loginpage;
    private BoardListPage board;
    private MyPage mypage;
    private UserManager uManager;
    private CategoryManagePage cmPage = new CategoryManagePageImp();
    private BoardManagePage bmPage = new BoardManagePageImp();
    private UserManagePage umPage = new UserManagePageImp();
    private LogoutService logout;

    private User user;

    private final int EXIT = 0;

    public MainProgramImp() {
        this.uManager = new UserManager();
        this.mypage = new MyPageImp(uManager);
        this.board = new BoardListPageImp(uManager);
        this.loginpage = new LoginPageImp(uManager);
        this.logout = new LogoutServiceImp(uManager);

    }

    @Override
    public void mainRun() {
        int input = 0;
        // 반복
        do {
            user = uManager.getCurrentUser();
            System.out.println(user);
            if (user != null && user.getU_admin() == 1) {
                printAdminMenu();
            }else if (user != null && user.getU_admin() == 0) {
            	printLoginUserMenu();
            }else {
                printUserMenu();
            }

            try {
                // 메뉴 선택
                input = sc.nextInt();

                if (user != null && user.getU_admin() == 1) {

                    sm.selectMenu(input,
                            () -> cmPage.run(),
                            () -> bmPage.run(),
                            () -> umPage.run(),
                            () -> logout.run());

                } else if (user != null && user.getU_admin() == 0) {
                	
                	sm.selectMenu(input,
                            () -> board.run(),
                            () -> mypage.run(),
                            () -> logout.run());// 로그아웃 메서드 추가

                } else {
                    sm.selectMenu(input,
                            () -> loginpage.run(),
                            () -> board.run(),
                            () -> mypage.run(),
                            () -> logout.run()); // 로그아웃 메서드 추가

                }

            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);
        System.out.println("프로그램이 종료되었습니다.");
    }

    private void printAdminMenu() {
        System.out.println("============= 관리자 메뉴 =============");
        System.out.println("1. 카테고리 관리");
        System.out.println("2. 게시판 관리"); // 해당 게시판에서 공시사항 작성하기
        System.out.println("3. 회원 관리");
        System.out.println("4. 로그아웃");
        System.out.println("0. 프로그램 종료");
        System.out.println("====================================");
        System.out.print("입력 :");
    }

    private void printUserMenu() {
        System.out.println("============ 게시판 프로그램 ============");
        System.out.println("1. 로그인");
        System.out.println("2. 게시판");
        System.out.println("3. 마이페이지");
        System.out.println("4. 로그아웃");
        System.out.println("0. 프로그램 종료");
        System.out.println("=====================================");
        System.out.print("입력 :");
    }
    
    private void printLoginUserMenu() {
        System.out.println("============ 게시판 프로그램 ============");
        System.out.println("1. 게시판");
        System.out.println("2. 마이페이지");
        System.out.println("3. 로그아웃");
        System.out.println("0. 프로그램 종료");
        System.out.println("=====================================");
        System.out.print("입력 :");
    }

}
