package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String u_id; // 사용자 ID
    private String u_pw; // 사용자 비밀번호
    private String u_mail; // 사용자 이메일
    private String u_phone; // 사용자 전화번호
    private String u_name; // 사용자 이름
    private int u_admin; // 관리자 여부
    private int u_try; // 로그인 시도 횟수
    private boolean uStatement = false;
    
    //아이디 중복확인
    public User(String uId) {
    	this.u_id = uId;
    }

	public User(String uId, String uPw, String uMail, String uPhone, String uName) {
		this.u_id = uId;
		this.u_pw = uPw;
		this.u_mail = uMail;
		this.u_phone = uPhone;
		this.u_name = uName;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_pw=" + u_pw + ", u_mail=" + u_mail + ", u_phone=" + u_phone + ", u_name="
				+ u_name + ", u_admin=" + u_admin + ", u_try=" + u_try + ", uStatement=" + uStatement + "]";
	}
	
	
    
}
