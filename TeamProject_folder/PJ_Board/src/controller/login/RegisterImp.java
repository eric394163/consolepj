package controller.login;

import java.util.Scanner;

public class RegisterImp implements Register {

	private Scanner sc = new Scanner(System.in);
	private final int EXIT = 0;
	
    @Override
    public void run() {
    	
    	while(true) {
    	
	    	System.out.println("[처음부터 입력하려면 1을 입력하세요.]");
	    	System.out.println("[이전 메뉴로 돌아가려면 0을 입력하세요.]");
	    	
	    	System.out.print("본명 입력 : ");
	    	String name = sc.next();
	    	System.out.print("아이디 입력 : ");
	    	
	    	System.out.print("비밀번호 입력 : ");
	    	
	    	System.out.print("비밀번호 확인 : ");
	    	
	    	System.out.print("이메일 입력 : ");
	    	
	    	System.out.print("전화번호 입력 : ");
	    	
	    	
    	}
    }

}
