package controller.board;

import java.util.InputMismatchException;
import java.util.Scanner;

import manager.UserManager;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class BoardPageImp implements BoardListPage {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();

    private final int EXIT = 0;

    public BoardPageImp(UserManager uManager) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
    	System.out.println("게시글 조회 구현 예정");
        int input = 0;
        // 반복
        do {
            // 카테고리와 해당 카테고리 게시판 보여주기

            try {
                // 카테고리 이름과 해당 카테고리 번호 입력

                // 해당 게시판을 보여주는 코드 실행

                // 0을 입력하면 뒤로가기

            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);

    }

}
