package controller.board;

import java.util.InputMismatchException;
import java.util.Scanner;

import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class BoardPageImp implements BoardPage {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();

    private final int EXIT = 0;

    @Override
    public void run() {
        int input = 0;
        // 반복
        do {
            // 카테고리와 해당 카테고리 게시판 보여주기
        	// 일단 mybatis 작동 확인을 위해 카테고리만 출력해보겠음!

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
