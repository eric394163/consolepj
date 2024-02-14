package service.login;

public interface LoginService {
    boolean validateLogin(String userId, String userPw);
}
