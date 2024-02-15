package controller.board;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.post.PostListPage;
import controller.post.PostListPageImp;
import model.Board;
import model.Category;
import service.board.BoardService;
import service.board.BoardServiceImp;
import service.category.CategoryService;
import service.category.CategoryServiceImp;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class BoardListPageImp implements BoardListPage {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();
    private CategoryService categoryService = new CategoryServiceImp();
    private BoardService boardService = new BoardServiceImp();
    private PostListPage postList = new PostListPageImp();
    private ArrayList<Category> categoryList;
    private ArrayList<Board> boardList;

    private final int EXIT = 0;

    @Override
    public void run() {
    	
//        int input = 0;

        // 카테고리와 해당 카테고리 게시판 보여주기
    	// 일단 mybatis 작동 확인을 위해 카테고리만 출력해보겠음!
    	System.out.println("\n\n\n\n\n\n");
    	categoryList = categoryService.selectCategory();
		
		if(categoryList == null || categoryList.size() == 0) {
			System.out.println("등록된 카테고리가 없습니다.");
			return;
		}
//		System.out.println(categoryList);
		// 카테고리가 있을 경우 카테고리 출력
		for(Category tmpCate : categoryList) {
			System.out.println("---"+tmpCate.getCName()+"---");
			
			// 특정 카테고리의 게시판 리스트를 불러오기
			ArrayList<Board> boardList = boardService.selectBoard(tmpCate.getCNum());
			
			if(boardList == null || boardList.size() == 0) {
    			System.out.println("(빈 카테고리)");
    			continue; // 아래 코드를 실행하지 않고, 다음 단계 반복문 실행
    		}
			
			for(int j = 0; j<boardList.size(); ) {
				Board tmpBoard = boardList.get(j);
				System.out.println("["+ ++j +"] "+ tmpBoard.getbName());
			}
			System.out.println("\n");
			
		}
		
		System.out.println("====================================");
		System.out.println("[이전으로 돌아가려면 0을 입력하세요]");
		
		// 카테고리 입력받기
		Category selectedCate = inputCategory();
		// 게시판 입력받기
		Board selectedBoard = inputBoard(selectedCate.getCNum());
		
		// 선택된 게시판의 고유번호, 카테고리 이름, 게시판 이름을 넘겨주기
		postList.run(selectedBoard.getbNum(), selectedCate.getC_name(), selectedBoard.getbName());
		
//		int selectedBnum = selectBoard();
//		if(selectedBnum != -1) {
//			postList.run(selectedBnum, cateName, boardName);
//		}
		
    }
    
    // 카테고리를 입력 받는 메서드
	private Category inputCategory() {
		String categoryInput="";
		
		 do {
	            try {
	            	
	                // 카테고리 이름과 해당 카테고리 번호 입력
	        		System.out.print("카테고리 이름 입력: ");
	        		categoryInput = sc.nextLine();

	            	} catch (InputMismatchException e) {
		                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
	            	}

        	Category tmp = new Category(categoryInput);
        	
	        // 입력받은 카테고리가 존재하지 않을 경우
    		if(!categoryList.contains(tmp)) {
    			System.out.println("\n해당 카테고리가 존재하지 않습니다. 다시 입력해주세요.");
    		}else {
    			// 존재하는 경우 해당 카테고리 반환
    			for(int i = 0; i<categoryList.size(); i++) {
    				if(categoryList.get(i).equals(tmp)) {
    					int idx = categoryList.indexOf(tmp);
    					
    					return categoryList.get(idx);
    				}
    			}
    			
    			
    		}
		 } while (!categoryInput.equals(EXIT+""));
		 
		 return null;
		
	}

	// 게시판을 입력받는 메서드
	private Board inputBoard(int cNum) {
		int boardInput=-1;
		boardList = boardService.selectBoard(cNum);
		
        do {
        	
            try {
        		System.out.print("게시판 번호 입력: ");
        		boardInput = sc.nextInt() -1;
        		sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
            }
            
            try {
    			// 존재할 경우, 해당 게시판의 고유 게시판 번호 리턴
//                System.out.println(boardList.get(boardInput));
                return boardList.get(boardInput);
                
            } catch (IndexOutOfBoundsException e) {
            	System.out.println("\n해당 게시판 번호가 존재하지 않습니다. 다시 입력해주세요.");
            }

    		
        } while (boardInput != EXIT-1);
        
        return null;
	}
	
	
	
	
	
	
	

		
	}


