package db;

import org.apache.ibatis.annotations.Param;


public interface UserInfoDB {

	boolean updatePw(@Param("u_id")String u_id, @Param("u_pw")String u_pw);

	boolean updateName(@Param("u_id")String u_id, @Param("u_name")String u_name);

	boolean updatePhone(@Param("u_id")String u_id, @Param("u_phone")String u_phone);

	boolean updateEmail(@Param("u_id")String u_id,  @Param("u_mail")String u_mail);

}
