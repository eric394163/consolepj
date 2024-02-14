package db;

import model.User;

public interface LoginDB {

    User findUserById(String userId);


}
