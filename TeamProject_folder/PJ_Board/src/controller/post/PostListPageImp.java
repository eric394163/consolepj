package controller.post;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Post;
import service.post.PostService;
import service.post.PostServiceImp;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class PostListPageImp implements PostListPage {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();
    private PostService postService = new PostServiceImp();
    private ArrayList<Post> postList;

    private final int EXIT = 0;
    private final int PAGE_SIZE = 5;

	@Override
	public void run(int selectedBnum, String cateName, String boardName) {
		int input = -1;
		
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
							()-> System.out.println("이전"),
							()-> System.out.println("다음"),
							()-> System.out.println("게시글 조회"),
							()-> System.out.println("게시글 작성"));
				}

			}catch(InputMismatchException e) {
				System.out.println();
			}
			
		}while(input != EXIT);
		
		
		
	}

	private void printPostList() {
		// 게시글 목록 띄우기
		postList = postService.selectPostList(selectedBnum);
		System.out.println(postList);
		
		//[A카테고리][일상]
		System.out.println("["+cateName+" 카테고리] ["+boardName+"]");
		
		// [(게시글 번호)] (게시글 제목) + (작성자) + [(댓글 갯수)] + 작성잘짜 + 조회수
		for(int i =0; i<postList.size(); i++) {
			System.out.println("["+ (i+1)+"] "+postList.get(i));
		}
		// 글 목록을 출력해주는 메서드
		printPostList(시작 끝);
		
		System.out.println("===========================================================");
		System.out.println("[1: 이전] [2: 다음] [3: 게시글 조회] [4: 게시글 작성] [0: 뒤로가기]");
		System.out.println("===========================================================");
				
	}

}
