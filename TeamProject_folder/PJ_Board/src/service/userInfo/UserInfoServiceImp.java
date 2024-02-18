package service.userInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.BoardDB;
import db.CategoryDB;
import db.UserInfoDB;
import model.Board;

public class UserInfoServiceImp implements UserInfoService {
	
	private UserInfoDB userinfodb;
	
	public UserInfoServiceImp(){
		String resource = "config/mybatis-config.xml";
		
		InputStream inputStream;
		SqlSession session;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			userinfodb = session.getMapper(UserInfoDB.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean updatePw(String u_id, String u_pw) {
		return userinfodb.updatePw(u_id, u_pw);
		
	}

	@Override
	public boolean updateName(String u_id, String name) {
		return userinfodb.updateName(u_id, name);
	}

	@Override
	public boolean updatePhone(String u_id, String phoneNum) {
		return userinfodb.updatePhone(u_id, phoneNum);
	}

	@Override
	public boolean updateEmail(String u_id, String email) {
		return userinfodb.updateEmail(u_id, email);
	}

	@Override
	public boolean deleteUser(String u_id) {
		return  userinfodb.deleteUser(u_id);
	}

	@Override
	public boolean deletePostByUser(String u_id) {
		return  userinfodb.deletePostByUser(u_id);
		
	}

//	@Override
//	public boolean deleteCommentByUser(String u_id) {// TODO Auto-generated method stub
//		return  userinfodb.deleteCommentByUser(u_id);
//	}


}
