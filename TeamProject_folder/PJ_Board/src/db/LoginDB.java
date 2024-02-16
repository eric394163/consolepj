package db;

import org.apache.ibatis.annotations.Param;

import model.User;

public interface LoginDB {

    User findUserById(@Param("u_id")String userId);


}
