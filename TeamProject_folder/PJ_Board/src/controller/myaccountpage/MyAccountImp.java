package controller.myaccountpage;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import manager.UserManager;
import model.User;
import service.login.LoginService;
import service.login.LoginServiceImp;
import service.login.RegisterService;
import service.login.RegisterServiceImp;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;
import service.userInfo.UserInfoService;
import service.userInfo.UserInfoServiceImp;

public class MyAccountImp implements MyAccount{
	private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();
    private UserInfoService userinfoService = new UserInfoServiceImp();
	private RegisterService registerService = new RegisterServiceImp();
    private LoginService ls = new LoginServiceImp();
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
            System.out.println("============= 내 계정 관리 ============");
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
                if (input==EXIT) {
                	return;
                }
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
        } while (true);
    }
    
	//본명
	private void changeName() {
		
    	//성명 정규표현식
		String regexName = "^[가-힣]{2,}$"; //한글 2글자 이상
		String name = null;

    	System.out.println("[이전 메뉴로 돌아가려면 0을 입력하세요.]");
		while(true) {
			System.out.println("====================================");

				System.out.print("새로운 이름 입력 : ");
				name = sc.next();
				if(name.equals("0")) {
		    		break;
		    	}
				
				if(!Pattern.matches(regexName, name)) {
					System.out.println("2글자 이상의 한글 이름을 입력해주세요.");
				}
				else if(name.equals(uManager.getCurrentUser().getU_name())) {
					System.out.println("기존 이름과 같습니다. 다시 입력해주세요.");
				}else {
					break;
				}
		}
		// 이름 변경
		if (userinfoService.updateName(uManager.getCurrentUser().getU_id(), name) == true) {
			System.out.println("이름이 변경되었습니다.");
			// 변경된 정보를 DB에서 새로 읽어옴
			User user = ls.getUser(uManager.getCurrentUser().getU_id());
            uManager.setCurrentUser(user);
		}else {
			System.out.println("오류 발생");
		}
		
	}

	private void changePhone() {
		String regexPhoneNum = "^010-[0-9]{4}-[0-9]{4}$";
		String phoneNum = "";
		int userPhoneNum = 0;
		do {			
			System.out.print("전화번호 입력(010-XXXX-XXXX) : ");
			phoneNum = sc.next();
			if(phoneNum.equals("0")) {
	    		return;
	    	}
			
			if(!Pattern.matches(regexPhoneNum, phoneNum)) {
				System.out.println("전화번호는 010-XXXX-XXXX 형식으로 입력해주세요.");
				continue;
			}
			
	    	userPhoneNum = registerService.getUserPhoneNum(phoneNum);
	    	if(userPhoneNum == 1) {
	    		System.out.println("중복된 전화번호입니다.");
	    		continue;
	    	}else {
	    		break;
	    	}
	    	
	    	
		}while(true);
		
		if (userinfoService.updatePhone(uManager.getCurrentUser().getU_id(), phoneNum) == true) {
			System.out.println("전화번호가 변경되었습니다.");
			// 변경된 정보를 DB에서 새로 읽어옴
			User user = ls.getUser(uManager.getCurrentUser().getU_id());
            uManager.setCurrentUser(user);
		}else {
			System.out.println("오류 발생");
		}
		
	}

	private void changeEmail() {
		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		String email = "";
		do {
			System.out.print("이메일 입력 : ");
			email = sc.next();
			if(email.equals("0")) {
	    		return;
	    	}
			
			if(!Pattern.matches(regexEmail, email)) {
				System.out.println("이메일은 xxxx@xxx.xxx 형식으로 입력해주세요.");
				continue;
			}else if(email.equals(uManager.getCurrentUser().getU_mail()) ){
				System.out.println("기존의 이메일과 같은 이메일입니다. 다른 이메일을 입력해주세요.");
				continue;
			}
			
    		if (userinfoService.updateEmail(uManager.getCurrentUser().getU_id(), email) == true) {
    			System.out.println("이메일이 변경되었습니다.");
    			// 변경된 정보를 DB에서 새로 읽어옴
    			User user = ls.getUser(uManager.getCurrentUser().getU_id());
                uManager.setCurrentUser(user);
    		}else {
    			System.out.println("오류 발생");
    		}
    		
    		return;		
    		
		}while(true);
		
		
	}

	private void changePw() {
		//비밀번호
		//비밀번호 정규표현식
		String regexPw = "^.*(?=^.{8,20}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
		String pw = "";
		System.out.println("[이전 메뉴로 돌아가려면 0을 입력하세요.]");
		do {
			System.out.print("새로운 비밀번호 입력 : ");
			pw = sc.next();
			if(pw.equals("0")) {
				System.out.println("비밀번호 변경이 취소되었습니다.");
	    		return;
	    	}
			
			if(!Pattern.matches(regexPw, pw)) {
				System.out.println("비밀번호는 영문자 대소문자, 숫자, 특수문자(!@#$%) 포함하여 8~20자를 생성해주세요.");
				continue;
			}else if(pw.equals(uManager.getCurrentUser().getU_pw())){
				System.out.println("기존 비밀번호와 같습니다. 다른 비밀번호를 입력해주세요.");
				continue;
			}
			break;
		}while(true);
		
		
		// 비번확인
		String pwConfirm = "";
		do {
			System.out.print("비밀번호 확인 : ");
			pwConfirm = sc.next();
			if(pwConfirm.equals("0")) {
				System.out.println("비밀번호 변경이 취소되었습니다.");
	    		return;
	    	}
			
			if(!pw.equals(pwConfirm)) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}else {
				break;
			}
			
		}while(true);
		
		// 비밀번호 변경
		if (userinfoService.updatePw(uManager.getCurrentUser().getU_id(), pw) == true) {
			System.out.println("비밀번호가 변경되었습니다.");
			// 변경된 정보를 DB에서 새로 읽어옴
			User user = ls.getUser(uManager.getCurrentUser().getU_id());
            uManager.setCurrentUser(user);
		}else {
			System.out.println("오류 발생");
		}
	}


    
    
    
    
    
    
    
}
