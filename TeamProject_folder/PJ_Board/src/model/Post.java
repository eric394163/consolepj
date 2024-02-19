package model;

import java.text.SimpleDateFormat;
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
	public String getP_date() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		String f_p_date = simpleDateFormat.format(p_date);
		return f_p_date;
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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		String f_p_date = simpleDateFormat.format(p_date);
		// (게시글 제목) + (작성자) + [(댓글 갯수)] + 작성잘짜 + 조회수
		return p_title + "\t" + p_u_id + "\t" + f_p_date + "\t" + p_view;
	}

	public Post(String p_title, String p_content, int p_b_Num, String p_u_id) {
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_b_Num = p_b_Num;
		this.p_u_id = p_u_id;
	}

	public Post(int p_num, String p_title, String p_content) {
		this.p_num = p_num;
		this.p_title = p_title;
		this.p_content = p_content;
	}

    
	
}
