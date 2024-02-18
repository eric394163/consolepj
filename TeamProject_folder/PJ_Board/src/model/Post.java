package model;

import java.util.Date;

public class Post {
    private int p_num; // 게시글 번호
    private String p_title; // 게시글 제목
    private String p_content; // 게시글 내용
    private Date p_date; // 게시일
    private int p_view; // 조회수
    private int p_b_Num; // 속한 게시판 번호
    private String p_u_id; // 작성자 ID
    
    public Post() {
    	
    }
    
	public int getP_num() {
		return p_num;
	}
	public String getP_title() {
		return p_title;
	}
	public String getP_content() {
		return p_content;
	}
	public Date getP_date() {
		return p_date;
	}
	public int getP_view() {
		return p_view;
	}
	public int getP_b_Num() {
		return p_b_Num;
	}
	public String getP_u_id() {
		return p_u_id;
	}
	
	@Override 
	public String toString(){
		// (게시글 제목) + (작성자) + [(댓글 갯수)] + 작성잘짜 + 조회수
		return p_title + "\t" + p_u_id + "\t" + p_date + "\t" + p_view;
	}

	public Post(String p_title, String p_content, int p_b_Num, String p_u_id) {
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_b_Num = p_b_Num;
		this.p_u_id = p_u_id;
	}

    
	
}
