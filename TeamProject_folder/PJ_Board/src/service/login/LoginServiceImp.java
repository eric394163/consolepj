package service.login;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.LoginDB;
import model.User;

public class LoginServiceImp implements LoginService {

    private LoginDB logindb;
    private User user;

    public LoginServiceImp() {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream;
        SqlSession session;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sessionFactory.openSession(true);
            logindb = session.getMapper(LoginDB.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validateLogin(String userId, String userPw) {
        user = logindb.findUserById(userId);
        if (user != null && user.getU_pw().equals(userPw)) {

            return true;
        }
        return false;
    }

    public User getUser(String userId) {
        return user = logindb.findUserById(userId);
    }


}
