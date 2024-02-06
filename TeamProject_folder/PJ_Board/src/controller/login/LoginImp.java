package controller.login;

import java.util.Scanner;

public class LoginImp implements Login {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        String inputId = "";
        String inputPw = "";

        // 반복
        while (true) {
            System.out.print("아이디 입력 :");
            inputId = sc.next();
            if (inputId.equals("1")) {
                continue;
            }
            System.out.print("비밀번호 입력 :");
            inputPw = sc.next();
            if (inputPw.equals("1")) {
                continue;
            }


            //로그인이 성공하면 break로 뒤로가기 

        }
    }
}
