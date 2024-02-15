package controller.admin;

import java.util.InputMismatchException;
import java.util.Scanner;


import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class CategoryManagePageImp implements CategoryManagePage {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();
    private CategoryManage cm;

    @Override
    public void run() {
        int input = 0;
        // 반복
        while (true) {
            // 메뉴 출력
            System.out.println("============ 카테고리관리 ============");
            System.out.println("1. 카테고리 등록");
            System.out.println("2. 카테고리 수정");
            System.out.println("3. 카테고리 삭제");
            System.out.println("0. 뒤로가기");
            System.out.println("====================================");
            System.out.print("입력 :");

            try {
                // 메뉴 선택
                input = sc.nextInt();
                if (input == 0) {
                    break;
                }
                // 메뉴 실행
                sm.selectMenu(input,
                        () -> cm.add(),
                        () -> cm.update(),
                        () -> cm.delete());
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        }
    }
}