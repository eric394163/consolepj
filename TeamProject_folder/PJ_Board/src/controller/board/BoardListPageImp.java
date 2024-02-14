package controller.board;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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

    private final int EXIT = 0;

    @Override
    public void run() {
        int input = 0;
        // 반복
        do {
            // 카테고리와 해당 카테고리 게시판 보여주기
        	// 일단 mybatis 작동 확인을 위해 카테고리만 출력해보겠음!
        	ArrayList<Category> categoryList = categoryService.selectCategory();
    		
    		if(categoryList == null || categoryList.size() == 0) {
    			System.out.println("등록된 카테고리가 없습니다.");
    			return;
    		}
    		//수정할 내역이 있으면 수정 가능한 내역을 출력
    		for(int i = 0; i<categoryList.size(); ) {
    			Category tmpCate = categoryList.get(i);
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
    			
    		}
        	
            try {
                // 카테고리 이름과 해당 카테고리 번호 입력

                // 해당 게시판을 보여주는 코드 실행

                // 0을 입력하면 뒤로가기

            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (input != EXIT);

    }

}
