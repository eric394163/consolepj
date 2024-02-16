package service.category;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.CategoryDB;
import model.Category;

public class CategoryServiceImp implements CategoryService {

    private CategoryDB categoryDB;

    public CategoryServiceImp() {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream;
        SqlSession session;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sessionFactory.openSession(true);
            categoryDB = session.getMapper(CategoryDB.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDB.getAllCategory();
    }

}
