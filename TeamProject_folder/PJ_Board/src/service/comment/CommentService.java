package service.comment;

import java.util.List;

import model.Comment;

public interface CommentService {

    List<Comment> getComment(int selectedPnum);

    boolean addComment(String us, int selectedPnum, String commentInput);


    
}
