package db;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.User;


public interface RegisterDB {

	boolean insertUser(@Param("user")User user);

	int selectUserId(String id);

	int selectUserEmail(String email);

	int selectUserPhoneNum(String phoneNum);
	
}
