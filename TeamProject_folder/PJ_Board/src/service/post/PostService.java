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

	public boolean deletePost(int p_num);

	public boolean updatePost(Post newPost);

    public void updatePostview(int selectedPnum, int view);

	public int countMyPostList(String u_id);

	public ArrayList<Post> selectMyPostList(String u_id, int startNum, int size);

	public String getMyPostBName(int selectedPbnum);

}
