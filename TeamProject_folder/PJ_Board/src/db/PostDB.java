package db;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.Board;
import model.Post;

public interface PostDB {

	ArrayList<Post> selectPostList(@Param("p_b_num")int p_b_num, @Param("start")int start, @Param("size")int size);

	 int countPostList(@Param("p_b_num")int p_b_num);
}
