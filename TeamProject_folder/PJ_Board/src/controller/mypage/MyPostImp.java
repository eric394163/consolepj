package controller.mypage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.post.PostInsertPage;
import controller.post.PostInsertPageImp;
import controller.post.PostViewPage;
import controller.post.PostViewPageImp;
import manager.UserManager;
import model.Post;
import model.User;
import service.post.PostService;
import service.post.PostServiceImp;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class MyPostImp implements MyPost {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();
    private PostService postService = new PostServiceImp();
    private PostInsertPage postInsertPage; 
    private PostViewPage postViewPage;

    private final int EXIT = 0;
    private final int PAGE_SIZE = 5;
    private int startNum = 0;
    private int postListSize;

	
	private UserManager uManager;
	private int bNum;
	private User user;
	private ArrayList<Post> postList;

	public MyPostImp(UserManager uManager) {
		this.uManager = uManager;
		//this.user = uManager.getCurrentUser();
	}
	
    @Override
    public void run() {
    	System.out.println("========== 내가 쓴 글 ==========");
    	int input = -1;
        
		// 게시글의 전체 갯수 구하기
		postListSize = postService.countMyPostList(uManager.getCurrentUser().getU_id());
		
		// 메뉴 선택하기
		do {
			// 게시글 목록을 출력하는 메서드
			printMyPostList(startNum, PAGE_SIZE);
			try{
				// 메뉴 입력받기
				System.out.print("메뉴 입력: ");
				input = sc.nextInt();
				sc.nextLine();
				
				if(input != 0) {
					// 선택한 메뉴에 따른 화면 출력하기
					sm.selectMenu(input, 
							()-> changePage(-5),
							()-> changePage(5),
							()-> selectPost());
				}

			}catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
			
		}while(input != EXIT);
    }
    
    
    private void changePage(int i) {
		// 맨 앞 페이지에서 앞으로 가려 하거나, 맨 뒤 페이지에서 뒤로 가려 할 때
		if((startNum==0 && i<0) || (startNum>postListSize-1) && i>0) {
			printMyPostList(startNum, PAGE_SIZE);
			return;
		}
		startNum += i;
		printMyPostList(startNum, PAGE_SIZE);
		
		
	}

	// 게시글 조회하기
	private void selectPost() {
		int selectedPidx = -1;		// 유저가 선택한 게시글 번호
		
		do {
			System.out.print("조회할 게시글 번호 입력: ");
			
			try {
				selectedPidx = sc.nextInt();
				sc.nextLine();
				
			}catch(InputMismatchException e){
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			
			}

			
			if(selectedPidx < 0 || selectedPidx>PAGE_SIZE) {
				System.out.println("유효한 수를 입력하세요.");
			}else if(selectedPidx == EXIT) {
				System.out.println("\n\n\n\n");
				break;
			}
			else {
				// 선택한 게시글의 고유번호 추출
				int selectedPnum = postList.get(selectedPidx-1).getP_num();
				// 선택한 게시글의 고유번호 추출
				int selectedPbnum = postList.get(selectedPidx-1).getP_b_Num();
//				System.out.println(selectedPnum);
				postViewPage  = new PostViewPageImp(uManager, selectedPnum, postService.getMyPostBName(selectedPbnum));
				postViewPage.run();
			}
			
		}while(true);
	}

	private void printMyPostList(int startNum, int size) {
		// 게시글 목록 띄우기
		postList = postService.selectMyPostList(uManager.getCurrentUser().getU_id(), startNum, size);
//		System.out.println(postList);
		
		//[A카테고리][일상]
		//System.out.println("\n\n\n\n"+info+"\n");
		
		// [(게시글 번호)] (게시글 제목) + (작성자) + [(댓글 갯수)] + 작성잘짜 + 조회수
		for(int i =0; i<postList.size(); i++) {
			System.out.println("["+ (i+1)+"] "+postList.get(i));
		}
		
		System.out.println("\n===========================================================");
		System.out.println("[1: 이전] [2: 다음] [3: 게시글 조회] [0: 뒤로가기]");
		System.out.println("===========================================================\n");
				
	}

	
}
