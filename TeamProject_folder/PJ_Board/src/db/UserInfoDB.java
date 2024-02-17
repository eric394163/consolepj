package db;

import org.apache.ibatis.annotations.Param;


public interface UserInfoDB {

	boolean updatePw(@Param("u_id")String u_id, @Param("u_pw")String u_pw);

}
