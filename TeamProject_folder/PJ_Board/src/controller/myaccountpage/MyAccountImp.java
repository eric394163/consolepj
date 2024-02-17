package controller.myaccountpage;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import manager.UserManager;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;
import service.userInfo.UserInfoService;
import service.userInfo.UserInfoServiceImp;

public class MyAccountImp implements MyAccount{
	private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();
    private UserInfoService userinfoService = new UserInfoServiceImp();
    private UserManager uManager;
		
	private final int EXIT = 0;
	
	public MyAccountImp(UserManager uManager){
		this.uManager = uManager;
	}

    @Override
    public void run() {
    	// 개발담당: 강인서 ==========================================================
    	int input = -1;
    	
    	do {
            // 메뉴 출력
            System.out.println("========== 게시판 프로그램 ==========");
            System.out.println("1. 비밀번호 변경");
            System.out.println("2. 이메일 변경");
            System.out.println("3. 전화번호 변경");
            System.out.println("4. 이름 변경");
            System.out.println("0. 뒤로가기");
            System.out.println("====================================");
            System.out.print("입력 :");

            try {
                // 메뉴 선택
                input = sc.nextInt();
                // 메뉴 실행
                sm.selectMenu(input,
                        () -> changePw(),
                        () -> changeEmail(),
                        () -> changePhone(),
                        () -> changeName());
                // () -> mypage.run()); 회원 탈퇴 메서드
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);
    }
    
	//본명
	private void changeName() {
		
    	//성명 정규표현식
		String regexName = "^[가-힣]{2,}$"; //한글 2글자 이상
		String name = null;

    	System.out.println("[이전 메뉴로 돌아가려면 0을 입력하세요.]");
		while(true) {
			System.out.println("=============================");

				System.out.print("새로운 이름 입력 : ");
				name = sc.next();
				if(name.equals("0")) {
		    		break;
		    	}
				else if(!Pattern.matches(regexName, name)) {
					System.out.println("2글자 이상의 한글 이름을 입력해주세요.");
				}
				else if(name.equals(uManager.getCurrentUser().getU_pw())) {
					System.out.println();
				}
		}
		// 이름 변경
		if (userinfoService.updateName(uManager.getCurrentUser().getU_id(), name) == true) {
			System.out.println("이름이 변경되었습니다.");
		}else {
			System.out.println("오류 발생");
		}
		
	}

	private void changePhone() {
		System.out.println("전화번호 변경 구현 예정");
		return;
	}

	private void changeEmail() {
		System.out.println("이메일 변경 구현 예정");
		return;
	}

	private void changePw() {
		//비밀번호
		//비밀번호 정규표현식
		String regexPw = "^.*(?=^.{8,20}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
		String pw = "";
		System.out.println("[이전 메뉴로 돌아가려면 0을 입력하세요.]");
		do {
			System.out.print("비밀번호 입력 : ");
			pw = sc.next();
			if(pw.equals("0")) {
				System.out.println("비밀번호 변경이 취소되었습니다.");
	    		return;
	    	}
			else if(!Pattern.matches(regexPw, pw)) {
				System.out.println("비밀번호는 영문자 대소문자, 숫자, 특수문자(!@#$%) 포함하여 8~20자를 생성해주세요.");
			}	
		}while(!Pattern.matches(regexPw, pw));
		
		
		// 비번확인
		String pwConfirm = "";
		do {
			System.out.print("비밀번호 확인 : ");
			pwConfirm = sc.next();
			if(pwConfirm.equals("0")) {
	    		return;
	    	}else if(!pw.equals(pwConfirm)) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}while(!pw.equals(pwConfirm));
		// 비밀번호 변경
				if (userinfoService.updatePw(uManager.getCurrentUser().getU_id(), pw) == true) {
					System.out.println("비밀번호가 변경되었습니다.");
				}else {
					System.out.println("오류 발생");
				}
	}


    
    
    
    
    
    
    
}
