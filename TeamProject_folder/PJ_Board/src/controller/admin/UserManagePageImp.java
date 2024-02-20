package controller.admin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.mypage.SignOut;
import controller.mypage.SignOutImp;
import model.User;
import service.userInfo.UserInfoService;
import service.userInfo.UserInfoServiceImp;

public class UserManagePageImp implements UserManagePage {
	private Scanner sc = new Scanner(System.in);

    private final int EXIT = 0;
    private ArrayList<User> userList;
    private UserInfoService userInfoService = new UserInfoServiceImp();
    private SignOut signout;

    @Override
    public void run() {
    	int input = -1;
    	printUserList();
    	
    	
    	do {
    		System.out.println("[뒤로 가려면 0을 입력하세요.]");
        	System.out.print("회원을 삭제하려면 번호를 입력하세요: ");
        	try {
        		
        		input = sc.nextInt()-1;
        		if(input == -1) {
        			return;
        		}
        		
        	}catch(InputMismatchException e) {
    			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
    			continue;
    		}catch(IndexOutOfBoundsException e) {
    			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
    			continue;
    		}
        	
        	System.out.println("정말로 "+userList.get(input).getU_id()+" 회원을 탈퇴시키겠습니까?\n(탈퇴 시 게시글과 댓글이 모두 삭제됩니다.)");
        	System.out.print("예(Y) / 아니오(아무 키): ");
			char tmp = sc.next().charAt(0);
			if(tmp == 'y' || tmp == 'Y') {
				// 회원 탈퇴 기능 시작
				signout = new SignOutImp(userList.get(input).getU_id());
				signout.run();
				printUserList();
			}else {
				System.out.println("\n\n\n회원 탈퇴를 취소했습니다.");
				
			}
        	
    	}while(input!=EXIT-1);
    	
    }

	private void printUserList() {
		userList = userInfoService.selectUserList();
		System.out.println("===========================회원 관리================================");
		if(userList.size()==0) {
			System.out.println("(가입한 유저 없음.)");
			return;
		}
        for(int i=0; i<userList.size(); i++) {
        	System.out.println("["+(i+1)+"]"+userList.get(i));
        }
    	System.out.println("\n===========================================================");
		
	}

}
