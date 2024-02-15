package service.post;

import java.util.ArrayList;

import model.Category;
import model.Post;

public interface PostService {

	public ArrayList<Post> selectPostList(int selectedBnum);

}
