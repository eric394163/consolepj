package controller.post;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import manager.UserManager;
import model.Post;
import service.post.PostService;
import service.post.PostServiceImp;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class PostListPageImp implements PostListPage {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();
    private PostService postService = new PostServiceImp();
    private PostInsertPage postInsertPage; 
    private PostViewPage postViewPage;
    private UserManager uManager;
    private ArrayList<Post> postList;
    private int postListSize;

    private final int EXIT = 0;
    private final int PAGE_SIZE = 5;
    private int startNum = 0;
    
    public PostListPageImp(UserManager uManager) {
        this.uManager = uManager;
    }

	@Override
	public void run(int selectedBnum, String cateName, String boardName) {
		int input = -1;
		
		// 게시글의 전체 갯수 구하기
		postListSize = postService.countPostList(selectedBnum);
//		System.out.println(postListSize);
		
		String info = "["+cateName+" 카테고리] ["+boardName+"]";
		
		// 게시글 목록을 출력하는 메서드
		printPostList(selectedBnum, info, startNum, PAGE_SIZE);
		
		// 메뉴 선택하기
		do {
			try{
				// 메뉴 입력받기
				System.out.print("메뉴 입력: ");
				input = sc.nextInt();
				sc.nextLine();
				
				if(input != 0) {
					// 선택한 메뉴에 따른 화면 출력하기
					sm.selectMenu(input, 
							()-> changePage(selectedBnum, info, -5),
							()-> changePage(selectedBnum, info, 5),
							()-> selectPost(boardName),
							()-> newPost(selectedBnum));
				}

			}catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
			
		}while(input != EXIT);
		
		
		
	}
	
	private void changePage(int bNum, String info, int i) {
		// 맨 앞 페이지에서 앞으로 가려 하거나, 맨 뒤 페이지에서 뒤로 가려 할 때
		if((startNum==0 && i<0) || (startNum>postListSize-1) && i>0) {
			printPostList(bNum, info, startNum, PAGE_SIZE);
//			System.out.println("시작페이지: "+startNum);
			return;
		}
		startNum += i;
		printPostList(bNum, info, startNum, PAGE_SIZE);
		
		
	}

	private void newPost(int bNum) {
		postInsertPage = new PostInsertPageImp(uManager, bNum);
		postInsertPage.run();
	}

	// 게시글 조회하기
	private void selectPost(String boardName) {
		int selectedPidx = -1;		// 유저가 선택한 게시글 번호
		
		do {
			System.out.print("조회할 게시글 번호 입력: ");
			
			try {
				selectedPidx = sc.nextInt();
				sc.nextLine();
				
			}catch(InputMismatchException e){
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			
			}
			
			if(selectedPidx < 1 || selectedPidx>PAGE_SIZE) {
				System.out.println("유효한 수를 입력하세요.");
			}else {
				
				// 선택한 게시글의 고유번호 추출
				int selectedPnum = postList.get(selectedPidx-1).getP_num();
//				System.out.println(selectedPnum);
				postViewPage  = new PostViewPageImp(uManager, selectedPnum, boardName);
				postViewPage.run();
			}
			
		}while(selectedPidx != 0);
	}

	private void printPostList(int bNum, String info, int startNum, int size) {
		// 게시글 목록 띄우기
		postList = postService.selectPostList(bNum, startNum, size);
//		System.out.println(postList);
		
		//[A카테고리][일상]
		System.out.println("\n\n\n\n"+info+"\n");
		
		// [(게시글 번호)] (게시글 제목) + (작성자) + [(댓글 갯수)] + 작성잘짜 + 조회수
		for(int i =0; i<postList.size(); i++) {
			System.out.println("["+ (i+1)+"] "+postList.get(i));
		}
		
		System.out.println("\n===========================================================");
		System.out.println("[1: 이전] [2: 다음] [3: 게시글 조회] [4: 게시글 작성] [0: 뒤로가기]");
		System.out.println("===========================================================\n");
				
	}

}
