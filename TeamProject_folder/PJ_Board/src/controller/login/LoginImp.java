package controller.login;

import java.util.Scanner;

import service.login.LoginService;
import service.login.LoginServiceImp;

public class LoginImp implements Login {
    private Scanner sc = new Scanner(System.in);
    private LoginService ls = new LoginServiceImp();

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
            if (inputId.equals("0")) {
                break;
            }
            System.out.print("비밀번호 입력 :");
            inputPw = sc.next();
            if (inputPw.equals("1")) {
                continue;
            }
            if (inputId.equals("0")) {
                break;
            }

        }

    }
}
