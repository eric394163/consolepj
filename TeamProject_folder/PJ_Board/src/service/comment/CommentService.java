package service.comment;

import java.util.List;

import model.Comment;

public interface CommentService {

    List<Comment> getComment(int selectedPnum);


    
}
