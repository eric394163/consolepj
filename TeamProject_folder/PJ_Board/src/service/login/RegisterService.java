package service.login;

import java.util.ArrayList;

import model.User;

public interface RegisterService {

	boolean insertUser(User user);
	int getUserId(String id);
	int getUserEmail(String email);
	int getUserPhoneNum(String phoneNum);
}
