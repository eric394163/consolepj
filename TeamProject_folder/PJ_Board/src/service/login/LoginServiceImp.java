package service.login;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.LoginDB;

public class LoginServiceImp implements LoginService {

    private LoginDB logindb;

    public LoginServiceImp() {
        String resource = "src/config/mybatis-config.xml";
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

    

}
