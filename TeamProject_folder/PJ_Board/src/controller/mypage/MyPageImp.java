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

    private MyAccount myaccount;
    private MyComment mycomment = new MyCommentImp();
    private SignOut signout;
    private MyPost mypost = new MyPostImp();
    private UserManager uManager;

    private final int EXIT = 0;
    private int input = 0;

    public MyPageImp(UserManager uManager) {
       this.uManager = uManager;
    }

    @Override
    public void run() {
        input = -1;
        
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
                if(input==0) {
                	return;
                }
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
		int inputAuth = -1;
		
		do {
			System.out.print("비밀번호 입력: ");
			String tmpPw = sc.next();
			
			if(tmpPw.equals(uManager.getCurrentUser().getU_pw())) {
				System.out.println("비밀번호가 일치합니다.");
				System.out.println("\n\n\n\n\n");
				break;
			}
			System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
		}while(inputAuth != EXIT);
		
		
		// 비밀번호 입력하고 일치하는지 확인한 후에 기능에 접근할 수 있도록 해야함.
		
		// 계정 정보 변경 페이지
		if(i == 1) {
			myaccount = new MyAccountImp(uManager);
			myaccount.run();
			System.out.println(uManager.getCurrentUser());
		}else { 
			// 회원 탈퇴 기능
			
			System.out.println("회원 탈퇴를 하시겠습니까?\n(탈퇴 시 게시글과 댓글이 모두 삭제됩니다.)");
			System.out.print("예(Y) / 아니오(N): ");
			char tmp = sc.next().charAt(0);
			if(tmp == 'y' || tmp == 'Y') {
				// 회원 탈퇴 기능 시작
				signout = new SignOutImp(uManager);
				signout.run();
				// 회원 탈퇴 후 마이페이지 화면을 자동으로 빠져나감.
				input = 0;
				
				uManager.setCurrentUser(null);
			}else {
				System.out.println("\n\n\n회원 탈퇴를 취소했습니다.");
				
			}
		}
	}

}
