package service.login;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.RegisterDB;
import model.User;

public class RegisterServiceImp implements RegisterService {

	private RegisterDB registerDb;
    private User user;

    public RegisterServiceImp() {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream;
        SqlSession session;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sessionFactory.openSession(true);
            registerDb = session.getMapper(RegisterDB.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
	public boolean insertUser(User user) {
		if(user == null || user.getUId() == null) {
			return false;
		}
		return registerDb.insertUser(user);
	}
    
    @Override
	public ArrayList<User> getUser() {
		return registerDb.selectUser();
	}
	
}
