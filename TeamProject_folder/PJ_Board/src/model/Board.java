package model;

public class Board {
    private int bNum; // 게시판 번호
    private String bName; // 게시판 이름
    private int bCNum; // 속한 카테고리 번호
    
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public int getbCNum() {
		return bCNum;
	}
	public void setbCNum(int bCNum) {
		this.bCNum = bCNum;
	}

  
}
