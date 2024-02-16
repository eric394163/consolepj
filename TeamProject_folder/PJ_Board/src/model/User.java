package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String u_Id; // 사용자 ID
    private String u_Pw; // 사용자 비밀번호
    private String u_Mail; // 사용자 이메일
    private String u_Phone; // 사용자 전화번호
    private String u_Name; // 사용자 이름
    private int u_Admin; // 관리자 여부
    private int u_Try; // 로그인 시도 횟수
    private boolean uStatement = false;

    

}
