package service.login;

import manager.UserManager;

public class LogoutServiceImp implements LogoutService {
    private UserManager uManager;

    public LogoutServiceImp(UserManager uManager) {
        this.uManager = uManager;
    }

    @Override
    public void run() {
        uManager.setCurrentUser(null);
        System.out.println("로그아웃 되었습니다.");

    }

}
