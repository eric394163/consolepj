package service.userInfo;

public interface UserInfoService {

	public boolean updatePw(String u_id, String u_pw);

	public boolean updateName(String u_id, String name);

	public boolean updatePhone(String u_id, String phoneNum);

	public boolean updateEmail(String u_id, String email);

	public boolean deleteUser(String uID);

	public boolean deletePostByUser(String uID);

//	public boolean deleteCommentByUser(String uID);

//	public boolean isBoard(String categoryInput);
}
