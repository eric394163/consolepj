package controller.mypage;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.myaccountpage.MyAccount;
import controller.myaccountpage.MyAccountImp;
import manager.UserManager;
import model.User;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class MyPageImp implements MyPage {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();

    private MyAccount myaccount = new MyAccountImp();
    private MyComment mycomment = new MyCommentImp();
    private MyPost mypost = new MyPostImp();

    private final int EXIT = 0;
	private UserManager uManager;
	private User user;

    public MyPageImp(UserManager uManager) {
    	this.uManager = uManager;
		this.user = uManager.getCurrentUser();
    }

    @Override
    public void run() {
		this.user = uManager.getCurrentUser();
    	if(user == null || user.isUStatement() == false) {
    		System.out.println("로그인이 필요합니다.");
    		return;
    	}
        int input = 0;
        // 반복
        do {
            // 메뉴 출력
            System.out.println("========== 게시판 프로그램 ==========");
            System.out.println("1. 내 계정 관리");
            System.out.println("2. 내 글 보기");
            System.out.println("3. 내 댓글 보기");
            System.out.println("4. 회원 탈퇴");
            System.out.println("0. 뒤로가기");
            System.out.println("====================================");
            System.out.print("입력 :");

            try {
                // 메뉴 선택
                input = sc.nextInt();
                // 메뉴 실행
                sm.selectMenu(input,
                        () -> myaccount.run(),
                        () -> mypost.run(),
                        () -> mycomment.run());
                // () -> mypage.run()); 회원 탈퇴 메서드
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);
    }

}
