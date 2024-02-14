package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.board.BoardPage;
import controller.board.BoardPageImp;
import controller.login.LoginPage;
import controller.login.LoginPageImp;
import controller.mypage.MyPage;
import controller.mypage.MyPageImp;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class MainProgramImp implements MainProgram {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();

    private LoginPage loginpage = new LoginPageImp();
    private BoardPage board = new BoardPageImp();
    private MyPage mypage = new MyPageImp();

    private final int EXIT = 0;

    public MainProgramImp() {

    }

    @Override
    public void mainRun() {
        int input = 0;
        // 반복
        do {
            // 메뉴 출력
            // 만약 일반 유저이면
            System.out.println("========== 게시판 프로그램 ==========");
            System.out.println("1. 로그인");
            System.out.println("2. 게시판");
            System.out.println("3. 마이페이지");
            System.out.println("4. 로그아웃");
            System.out.println("0. 프로그램 종료");
            System.out.println("====================================");
            System.out.print("입력 :");

            // 관리자이면
            // System.out.println("========== 게시판 프로그램 ==========");
            // System.out.println("1. 카테고리 관리");
            // System.out.println("2. 게시판 관리"); //해당 게시판에서 공시사항 작성하기
            // System.out.println("3. 회원 관리");
            // System.out.println("4. 로그아웃");
            // System.out.println("0. 프로그램 종료");
            // System.out.println("====================================");
            // System.out.print("입력 :");

            try {
                // 메뉴 선택
                input = sc.nextInt();

                // 일반 유저이면
                sm.selectMenu(input,
                        () -> loginpage.run(),
                        () -> board.run(),
                        () -> mypage.run()); // 로그아웃 메서드 추가
                

                // 관리자이면
                // sm.selectMenu(input,
                // () -> 카테고리관리.run(),
                // () -> 게시판관리.run(),
                // () -> 회원관리.run());
                // //로그아웃 메서드
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);

    }

}
