package service.category;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.CategoryDB;
import model.Category;

public class CategoryServiceImp implements CategoryService {
	
	private CategoryDB categorydb;
	
	CategoryServiceImp(){
		String resource = "src/config/mybatis-config.xml";
		
		InputStream inputStream;
		SqlSession session;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			categorydb = session.getMapper(CategoryDB.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public ArrayList<Category> getCategoryList() {
		return categorydb.selectCategoryList();
	}
	
}
