package service.post;

import java.util.ArrayList;

import model.Category;
import model.Post;

public interface PostService {

	public ArrayList<Post> selectPostList(int selectedBnum, int startNum, int size);

	public int countPostList(int selectedBnum);

	public Post getPost(int p_num);

	public String getPostBoard(int p_num);

	
	
	
	public boolean insertPost(Post post);

}
