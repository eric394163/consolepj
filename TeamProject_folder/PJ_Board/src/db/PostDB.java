package db;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.Board;
import model.Post;

public interface PostDB {

    ArrayList<Post> selectPostList(@Param("p_b_num") int p_b_num, @Param("start") int start, @Param("size") int size);

    int countPostList(@Param("p_b_num") int p_b_num);

    Post getPost(@Param("p_num") int p_num);

    String getPostBoard(@Param("p_b_num") int p_b_num);

    boolean insertPost(@Param("post") Post post);

    boolean deletePost(@Param("p_num") int p_num);

    boolean updatePost(@Param("newPost") Post newPost);

    void updatePostView(@Param("p_num") int selectedPnum, @Param("view") int view);

	int countMyPostList(@Param("u_id")String u_id);

	ArrayList<Post> selectMyPostList(@Param("u_id")String u_id, @Param("startNum")int startNum, @Param("size")int size);

	String getMyPostBName(@Param("p_b_num")int selectedPbnum);

}
