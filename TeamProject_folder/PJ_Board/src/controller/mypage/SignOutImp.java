package controller.mypage;

import service.userInfo.UserInfoService;
import service.userInfo.UserInfoServiceImp;

public class SignOutImp implements SignOut {

    private String u_id;
    private UserInfoService userinfoService = new UserInfoServiceImp();

    public SignOutImp(String string) {
       this.u_id = string;
    }

    @Override
    public void run() {
       
//        if(userinfoService.deleteCommentByUser(uID)) {
//        	System.out.println("댓글 삭제가 완료되었습니다.");
//        }else {
//        	System.out.println("댓글 삭제 중 오류 발생");
//        }
        System.out.println("댓글 삭제 기능 미구현");
        
        if(userinfoService.deletePostByUser(u_id)) {
        	System.out.println("게시글 삭제가 완료되었습니다.");
        }else {
        	System.out.println("게식르 삭제 중 오류 발생");
        }
        
        if(userinfoService.deleteUser(u_id)) {
        	System.out.println("회원탈퇴가 완료되었습니다.");
        	return;
        }else {
        	System.out.println("회원탈퇴 중 오류가 발생했습니다.");
        	return;
        }
    }

}
