package service.login;

import java.util.ArrayList;

import model.User;

public interface RegisterService {

	boolean insertUser(User user);
	int getUser(String id);
}
