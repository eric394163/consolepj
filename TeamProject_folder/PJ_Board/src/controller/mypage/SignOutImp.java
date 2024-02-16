package controller.mypage;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.myaccountpage.MyAccount;
import controller.myaccountpage.MyAccountImp;
import manager.UserManager;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class SignOutImp implements SignOut {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();

    private MyAccount myaccount = new MyAccountImp();
    private MyComment mycomment = new MyCommentImp();
    private MyPost mypost = new MyPostImp();
    private UserManager uManager;

    private final int EXIT = 0;

    public SignOutImp(UserManager uManager) {
       this.uManager = uManager;
    }

    @Override
    public void run() {
        int input = 0;
        
        // 로그인을 하지 않았을 경우
        if(uManager.getCurrentUser() == null) {
        	System.out.println("\n\n\n\n마이페이지는 로그인 이후 이용할 수 있습니다.\n");
        	return;
        }
        
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
                        () -> isAuthorized(1),
                        () -> mypost.run(),
                        () -> mycomment.run(),
                        () -> isAuthorized(2));
                // () -> mypage.run()); 회원 탈퇴 메서드
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);
    }

	private void isAuthorized(int i) {
		int input = -1;
		
		do {
			System.out.print("비밀번호 입력: ");
			String tmpPw = sc.next();
			
			if(tmpPw.equals(uManager.getCurrentUser().getU_Pw())) {
				System.out.println("비밀번호가 일치합니다.");
				break;
			}
		}while(input != EXIT);
		
		
		// 비밀번호 입력하고 일치하는지 확인한 후에 기능에 접근할 수 있도록 해야함.
		
		// 계정 정보 변경 페이지
		if(i == 1) {
			myaccount.run(uManager);
		}else { 
			// 회원 탈퇴 페이지
			
			System.out.println("회원 탈퇴를 하시겠습니까?");
			System.out.print("예(Y) / 아니오(N): ");
		}
		
	}

}
