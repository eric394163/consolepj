package service.post;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.PostDB;
import model.Post;

public class PostServiceImp implements PostService {
	
	private PostDB postdb;
	
	public PostServiceImp(){
		String resource = "config/mybatis-config.xml";
		
		InputStream inputStream;
		SqlSession session;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			postdb = session.getMapper(PostDB.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

//	@Override
//	public ArrayList<Post> selectPostList(int selectedBnum) {
//		
//	}


	@Override
	public ArrayList<Post> selectPostList(int selectedBnum, int start, int size) {
		return postdb.selectPostList(selectedBnum, start, size);
	}


	
}
