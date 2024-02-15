package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String uId; // 사용자 ID
    private String uPw; // 사용자 비밀번호
    private String uMail; // 사용자 이메일
    private String uPhone; // 사용자 전화번호
    private String uName; // 사용자 이름
    private int uAdmin; // 관리자 여부
    private int uTry; // 로그인 시도 횟수

    
    
    
    //아이디 중복확인
    public User(String uId) {
    	this.uId = uId;
    }




	public User(String uId, String uPw, String uMail, String uPhone, String uName) {
		this.uId = uId;
		this.uPw = uPw;
		this.uMail = uMail;
		this.uPhone = uPhone;
		this.uName = uName;
	}
    
    
}
