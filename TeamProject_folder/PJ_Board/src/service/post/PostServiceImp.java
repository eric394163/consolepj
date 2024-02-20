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

	public PostServiceImp() {
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

	// @Override
	// public ArrayList<Post> selectPostList(int selectedBnum) {
	//
	// }

	@Override
	public ArrayList<Post> selectPostList(int selectedBnum, int start, int size) {
		return postdb.selectPostList(selectedBnum, start, size);
	}

	@Override
	public int countPostList(int selectedBnum) {
		return postdb.countPostList(selectedBnum);
	}

	@Override
	public Post getPost(int p_num) {
		return postdb.getPost(p_num);
	}

	@Override
	public String getPostBoard(int p_num) {
		return postdb.getPostBoard(p_num);
	}

	
	
	@Override
	public boolean insertPost(Post post) {
		return postdb.insertPost(post);
	}

	@Override
	public boolean deletePost(int p_num) {
		return postdb.deletePost(p_num);
	}

	@Override
	public boolean updatePost(Post newPost) {
		return postdb.updatePost(newPost);
	}


	@Override
	public void updatePostview(int selectedPnum, int view) {
		postdb.updatePostView(selectedPnum, view);
	}

	@Override
	public int countMyPostList(String u_id) {
		return postdb.countMyPostList(u_id);
	}

	@Override
	public ArrayList<Post> selectMyPostList(String u_id, int startNum, int size) {
		return postdb.selectMyPostList(u_id, startNum, size);
	}

	@Override
	public String getMyPostBName(int selectedPbnum) {
		return postdb.getMyPostBName(selectedPbnum);
	}

}
