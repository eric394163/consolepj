package controller.myaccountpage;

import java.util.InputMismatchException;
import java.util.Scanner;

import manager.UserManager;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class MyAccountImp implements MyAccount{
	private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();
		
	private final int EXIT = 0;

    @Override
    public void run(UserManager uManager) {
    	int input = -1;
    	
    	do {
            // 메뉴 출력
            System.out.println("========== 게시판 프로그램 ==========");
            System.out.println("1. 비밀번호 변경");
            System.out.println("2. 이메일 변경");
            System.out.println("3. 전화번호 변경");
            System.out.println("4. 이름 변경");
            System.out.println("====================================");
            System.out.print("입력 :");

            try {
                // 메뉴 선택
                input = sc.nextInt();
                // 메뉴 실행
                sm.selectMenu(input,
                        () -> changePw(),
                        () -> changeMail(),
                        () -> changePhone(),
                        () -> changeName());
                // () -> mypage.run()); 회원 탈퇴 메서드
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);
    }
    
}
