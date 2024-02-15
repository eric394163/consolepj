package model;

public class Board {
    private int b_num; // 게시판 번호
    private String b_name; // 게시판 이름
    private int b_c_num; // 속한 카테고리 번호
    
    public Board(){}
    
	public int getbNum() {
		return b_num;
	}

	public String getbName() {
		return b_name;
	}
	int getbCNum() {
		return b_c_num;
	}

  
}
