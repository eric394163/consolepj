package db;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.Comment;

public interface CommentDB {

    List<Comment> getComment(@Param("p_num") int selectedPnum);

    void addComment(@Param("com_u_id") String us, @Param("com_p_num") int selectedPnum,
            @Param("com_content") String com_content);

}
