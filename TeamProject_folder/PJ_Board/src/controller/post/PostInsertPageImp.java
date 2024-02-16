package controller.post;

import java.util.Scanner;
import java.util.regex.Pattern;

import manager.UserManager;
import model.Post;
import model.User;
import service.post.PostService;
import service.post.PostServiceImp;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class PostInsertPageImp implements PostInsertPage {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();
    private PostService postService = new PostServiceImp();

    private User user;
    private UserManager uManager;
	private int bNum;
    
    private final int EXIT = 0;

 
	public PostInsertPageImp(UserManager uManager, int bNum) {
		this.uManager = uManager;
		this.bNum = bNum;
		this.user = uManager.getCurrentUser();
	}


	@Override
	public void run() {
		System.out.println(user);
		if (user != null && user.isUStatement() == true) {
			Post post = inputPost();
			if(postService.insertPost(post)) {
				System.out.println("게시글 작성이 완료되었습니다.");
			}else {
				System.out.println("게시글 작성을 실패하였습니다.");
			}
        } else {
            System.out.println("로그인이 필요합니다.");
            return;
        }
		
	}


	private Post inputPost() {
		System.out.println("========== 게시글 작성 ==========");
		System.out.println("[처음부터 입력하려면 1을 입력하세요.]");
    	System.out.println("[이전 메뉴로 돌아가려면 0을 입력하세요.]");
    	
    	while(true) {
    		System.out.println("==============================");
    		//제목
    		String regexTitle = "^.{1,50}$";
    		String title = null;
    		
    		do {
    			System.out.print("제목 : ");
    			title = sc.nextLine();
        		if(title.equals("0")) {
    	    		return null;
    	    	}
    	    	if(title.equals("1")) {
    	    		break;
    	    	}
    	    	if(!Pattern.matches(regexTitle, title)) {
					System.out.println("1자 이상, 50자 이하의 제목을 입력해주세요.");
				}
    		}while(!Pattern.matches(regexTitle, title));
    		if(title.equals("1")) {
	    		continue;
	    	}
    		
    		//내용
    		String regexContent = "^.{1,1000}$";
    		String content = null;
    		
    		do {
    			System.out.print("내용 : ");
    			content = sc.nextLine();
        		if(content.equals("0")) {
    	    		return null;
    	    	}
    	    	if(content.equals("1")) {
    	    		break;
    	    	}
    	    	if(!Pattern.matches(regexContent, content)) {
					System.out.println("1자 이상, 1000자 이하의 내용을 입력해주세요.");
				}
    		}while(!Pattern.matches(regexContent, content));
    		if(content.equals("1")) {
	    		continue;
	    	}
    		
//    		//게시일
//    		//현재 날짜 구하기
//    		LocalDate now = LocalDate.now();
//    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    		String formatedNow = now.format(formatter);
    		
    		
    		Post post = new Post(title, content, bNum, user.getU_id());
    		
    		return post;
    	}
		
	}

}
