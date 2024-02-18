package controller.login;

import java.util.Scanner;
import java.util.regex.Pattern;

import model.User;
import service.login.RegisterService;
import service.login.RegisterServiceImp;

public class RegisterImp implements Register {

	private Scanner sc = new Scanner(System.in);
	private RegisterService registerService = new RegisterServiceImp();

	@Override
	public void run() {

		User user = inputUser();
		if (user == null) {
			return;
		}
		if (registerService.insertUser(user)) {
			System.out.println("회원가입이 완료되었습니다.");
		} else {
			System.out.println("회원가입을 실패하였습니다.");
		}

	}

	private User inputUser() {
		System.out.println("=========== 회원 가입 ===========");
    	System.out.println("[처음부터 입력하려면 1을 입력하세요.]");
    	System.out.println("[이전 메뉴로 돌아가려면 0을 입력하세요.]");
		while(true) {
			System.out.println("=============================");
			// 본명
			// 성명 정규표현식
			String regexName = "^[가-힣]{2,}$"; // 한글 2글자 이상
			String name = null;
			do {
				System.out.print("본명 입력 : ");
				name = sc.next();
				if (name.equals("0")) {
					return null;
				}
				if (name.equals("1")) {
					break;
				}
				if (!Pattern.matches(regexName, name)) {
					System.out.println("2글자 이상의 한글 이름을 입력해주세요.");
				}
			} while (!Pattern.matches(regexName, name));
			if (name.equals("1")) {
				continue;
			}

			// 아이디
			// 아이디 정규표현식
			String regexId = "^[a-zA-Z][0-9a-zA-Z]{7,12}$";
			String id = null;
			int userId = 0;
			do {
				System.out.print("아이디 입력 : ");
				id = sc.next();
				if(id.equals("0")) {
		    		return null;
		    	}
		    	if(id.equals("1")) {
		    		break;
		    	}
				userId = registerService.getUserId(id);
		    	if(userId == 1) {
		    		System.out.println("중복된 아이디입니다.");
		    	}
				if(!Pattern.matches(regexId, id)) {
					System.out.println
					("아이디는 영문자 대소문자, 숫자 포함하여 8~13자를 생성해주세요.");
				}
			}while(userId == 1 || !Pattern.matches(regexId, id));
			if(id.equals("1")) {
	    		continue;
	    	}
			
			//비밀번호
			//비밀번호 정규표현식
			String regexPw = "^.*(?=^.{8,20}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
			String pw = null;
			do {
				System.out.print("비밀번호 입력 : ");
				pw = sc.next();
				if (pw.equals("0")) {
					return null;
				}
				if (pw.equals("1")) {
					break;
				}
				if (!Pattern.matches(regexPw, pw)) {
					System.out.println("비밀번호는 영문자 대소문자, 숫자, 특수문자(!@#$%) 포함하여 8~20자를 생성해주세요.");
				}
			} while (!Pattern.matches(regexPw, pw));
			if (pw.equals("1")) {
				continue;
			}

			// 비번확인
			String pwConfirm = null;
			do {
				System.out.print("비밀번호 확인 : ");
				pwConfirm = sc.next();
				if (pwConfirm.equals("0")) {
					return null;
				}
				if (pwConfirm.equals("1")) {
					break;
				}
				if (!pw.equals(pwConfirm)) {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} while (!pw.equals(pwConfirm));
			if (pwConfirm.equals("1")) {
				continue;
			}

			// 이메일
			// 이메일 정규표현식
			String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
			String email = null;
			int userEmail = 0;
			do {
				System.out.print("이메일 입력 : ");
				email = sc.next();
				if(email.equals("0")) {
		    		return null;
		    	}
		    	if(email.equals("1")) {
		    		break;
		    	}
		    	userEmail = registerService.getUserEmail(email);
		    	if(userEmail == 1) {
		    		System.out.println("중복된 이메일입니다.");
		    	}
		    	if(!Pattern.matches(regexEmail, email)) {
					System.out.println("이메일은 xxxx@xxx.xxx 형식으로 입력해주세요.");
				}
				
			}while(userEmail == 1 || !Pattern.matches(regexEmail, email));
			if(email.equals("1")) {
	    		continue;
	    	}
			
			//전화번호
			//전화번호 정규표현식
			String regexPhoneNum = "^010-[0-9]{4}-[0-9]{4}$";
			String phoneNum = null;
			int userPhoneNum = 0;
			do {			
				System.out.print("전화번호 입력(010-XXXX-XXXX) : ");
				phoneNum = sc.next();
				if(phoneNum.equals("0")) {
		    		return null;
		    	}
		    	if(phoneNum.equals("1")) {
		    		break;
		    	}
		    	userPhoneNum = registerService.getUserPhoneNum(phoneNum);
		    	if(userPhoneNum == 1) {
		    		System.out.println("중복된 전화번호입니다.");
		    	}
				if(!Pattern.matches(regexPhoneNum, phoneNum)) {
					System.out.println("전화번호는 010-XXXX-XXXX 형식으로 입력해주세요.");
				}
			}while(userPhoneNum == 1 || !Pattern.matches(regexPhoneNum, phoneNum));
			if(phoneNum.equals("1")) {
	    		continue;
	    	}
			
			User user = new User(id, pw, email, phoneNum, name);
			return user;
		}
	}

}
