package service.login;

import model.User;

public interface LoginService {
    boolean validateLogin(String userId, String userPw);

    User getUser(String userId);
}
