package controller.admin;

import java.util.InputMismatchException;
import java.util.Scanner;

import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class BoardManagePageImp implements BoardManagePage {

	private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();
    private BoardManage bm = new BoardManageImp();

    @Override
    public void run() {
        int input = 0;
        // 반복
        while (true) {
            // 메뉴 출력
            System.out.println("============== 게시판관리 ==============");
            System.out.println("1. 게시판 등록");
            System.out.println("2. 게시판 수정");
            System.out.println("3. 게시판 삭제");
            System.out.println("0. 뒤로가기");
            System.out.println("=====================================");
            System.out.print("입력 :");

            try {
                // 메뉴 선택
                input = sc.nextInt();
                if (input == 0) {
                    break;
                }
                // 메뉴 실행
                sm.selectMenu(input,
                        () -> bm.add(),
                        () -> bm.update(),
                        () -> bm.delete());
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        }
    }

}
