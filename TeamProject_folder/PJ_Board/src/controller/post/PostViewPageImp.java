package controller.post;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import manager.UserManager;

import model.Comment;
import model.Post;
import model.User;

import service.comment.CommentService;
import service.comment.CommentServiceImp;
import service.post.PostService;
import service.post.PostServiceImp;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class PostViewPageImp implements PostViewPage {

	private Scanner sc = new Scanner(System.in);
	private SelectMenu sm = new SelectMenuImp();
	private UserManager uManager;
	private int selectedPnum;
	private PostService ps = new PostServiceImp();
	private CommentService cs = new CommentServiceImp();
	private String boardName;


	public PostViewPageImp(UserManager uManager, int selectedPnum, String boardName) {
		this.uManager = uManager;
		this.selectedPnum = selectedPnum;
		this.boardName = boardName;
	}

	@Override
	public void run() {
		//Post post = ps.getPost(selectedPnum);
		User user = uManager.getCurrentUser();

		while (true) {
			Post post = ps.getPost(selectedPnum);

			System.out.println("===============================");
			System.out.println("제목 : " + post.getP_title());
			System.out.println("게시판 : " + boardName);
			System.out.println("작성자 : " + post.getP_u_id());
			System.out.println("작성 날짜 : " + post.getP_date());
			System.out.println("내용 : " + post.getP_content());
			System.out.println("===============================");

			List<Comment> commentList = cs.getComment(selectedPnum);

			displayComment(commentList);

			if (user != null && user.isUStatement() == true && user.getU_id().equals(post.getP_u_id())) {
				System.out.println("===================================");
				System.out.println("[ 게시글 삭제 : 1 ]  [ 게시글 수정: 2 ] [ 종료 : 0 ]");
				System.out.println("===================================");
				System.out.print("입력 : ");
				int input = sc.nextInt();

				if (input == 1) {
					//게시글 삭제
					if(ps.deletePost(post.getP_num())) {
						System.out.println("게시글 삭제가 완료되었습니다.");
					}else {
						System.out.println("게시글 삭제를 실패하였습니다.");
					}
					
				} else if (input == 2) {
					//게시글 수정
					Post newPost = updatePost(post, user);
					if(ps.updatePost(newPost)) {
						System.out.println("게시글 수정이 완료되었습니다.");
					}else {
						System.out.println("게시글 수정을 실패하였습니다.");
					}
					
					
				} else if (input == 0) {
					break;
					
				}

			} else {
				break;
			}

		}
	}

	private Post updatePost(Post post, User user) {
		System.out.println("========== 게시글 수정 ==========");
		System.out.println("[처음부터 입력하려면 1을 입력하세요.]");
    	System.out.println("[이전 메뉴로 돌아가려면 0을 입력하세요.]");
    	
    	while(true) {
    		System.out.println("==============================");
    		//제목
    		String regexTitle = "^.{1,50}$";
    		String title = null;
    		
    		do {
    			sc.nextLine();
    			System.out.println("기존 제목 : " + post.getP_title());
    			System.out.print("수정 제목 : ");
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
    			System.out.println("기존 내용 : " + post.getP_content());
    			System.out.print("수정 내용 : ");
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
    		
    		
    		Post newPost = new Post(post.getP_num(), title, content);
    		
    		return newPost;
    	}
	}

	private void displayComment(List<Comment> commentList) {

		int input = 0;
		int currentPage = 0;
		final int pageSize = 5; // 한 페이지에 들어갈 항목 수
		int totalPages = (commentList.size() + pageSize - 1) / pageSize; // 총 페이지 수 계산

		do {
			System.out.println("======= (댓글 페이지 " + (currentPage + 1) + " / " + totalPages
					+ ") ==========");
			printComments(currentPage * pageSize, pageSize, commentList);

			System.out.println("[ 이전 : 1 ]  [ 다음 : 2 ] [ 댓글 작성 : 3 ]");
			System.out.println("[ 종료 : 0 ]");
			System.out.println("===================================");
			System.out.print("입력 : ");
			input = sc.nextInt();

			if (input == 1 && currentPage > 0) {
				currentPage--;
			} else if (input == 2 && currentPage < totalPages - 1) {
				currentPage++;
			} else if (input == 3) {
				// 댓글 작성 구현

			}
		} while (input != 0);

	}

	private void printComments(int startIndex, int pageSize, List<Comment> commentList) {
		if (commentList.isEmpty()) {
			System.out.println("댓글 없음");
			return;
		}

		int endIndex = Math.min(startIndex + pageSize, commentList.size());
		for (int i = startIndex; i < endIndex; i++) {
			Comment comment = commentList.get(i);
			System.out.println("사용자 이름 : " + comment.getCom_UId());
			System.out.println("댓글 내용 : " + comment.getCom_Content());
			System.out.println("댓글 작성일 : " + comment.getCom_Date());
			System.out.println("-------------------------------------");
		}
	}

}
