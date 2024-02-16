package model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Comment {
    private int com_Num; // 댓글 번호
    private String com_Content; // 댓글 내용
    private Date com_Date; // 댓글 작성일
    private String com_UId; // 댓글 작성자 ID
    private int com_PNum; // 속한 게시글 번호
}
