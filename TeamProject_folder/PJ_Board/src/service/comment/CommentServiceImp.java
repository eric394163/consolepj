package service.comment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.CommentDB;
import model.Comment;

public class CommentServiceImp implements CommentService {

    CommentDB commentdb;

    public CommentServiceImp() {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream;
        SqlSession session;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sessionFactory.openSession(true);
            commentdb = session.getMapper(CommentDB.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> getComment(int selectedPnum) {

        List<Comment> commentList = commentdb.getComment(selectedPnum);
        return commentList;

    }

}
