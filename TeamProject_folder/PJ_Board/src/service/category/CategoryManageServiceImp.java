package service.category;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.CategoryDB;

import model.Category;

public class CategoryManageServiceImp implements CategoryManageService {

    private CategoryDB categoryDB;
    private Category category;

    public CategoryManageServiceImp() {
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
    public void add(String inputCategoryName) {

        categoryDB.addCategory(inputCategoryName);
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update(String inputCategoryName, String inputUpdateCategoryName) {
        Map<String, Object> params = new HashMap<>();
        params.put("oldCategoryName", inputCategoryName);
        params.put("newCategoryName", inputUpdateCategoryName);
        categoryDB.updateCategory(params);
    }

}
