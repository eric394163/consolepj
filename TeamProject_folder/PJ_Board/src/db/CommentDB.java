package db;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.Comment;

public interface CommentDB {

    List<Comment> getComment(@Param("p_num") int selectedPnum);

}
