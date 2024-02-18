package controller.mypage;

import manager.UserManager;
import service.userInfo.UserInfoService;
import service.userInfo.UserInfoServiceImp;

public class SignOutImp implements SignOut {

    private UserManager uManager;
    private UserInfoService userinfoService = new UserInfoServiceImp();

    public SignOutImp(UserManager uManager) {
       this.uManager = uManager;
    }

    @Override
    public void run() {
        String uID = uManager.getCurrentUser().getU_id();
       
//        if(userinfoService.deleteCommentByUser(uID)) {
//        	System.out.println("댓글 삭제가 완료되었습니다.");
//        }else {
//        	System.out.println("댓글 삭제 중 오류 발생");
//        }
        System.out.println("댓글 삭제 기능 미구현");
        
        if(userinfoService.deletePostByUser(uID)) {
        	System.out.println("게시글 삭제가 완료되었습니다.");
        }else {
        	System.out.println("게식르 삭제 중 오류 발생");
        }
        
        if(userinfoService.deleteUser(uID)) {
        	System.out.println("회원탈퇴가 완료되었습니다.");
        	return;
        }else {
        	System.out.println("회원탈퇴 중 오류가 발생했습니다.");
        	return;
        }
    }

}
