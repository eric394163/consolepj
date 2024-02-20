package controller.admin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Board;
import model.Category;
import service.board.BoardManageService;
import service.board.BoardManageServiceImp;
import service.board.BoardService;
import service.board.BoardServiceImp;
import service.category.CategoryService;
import service.category.CategoryServiceImp;
import service.print.PrintService;
import service.print.PrintServiceImp;

public class BoardManageImp implements BoardManage {

    private BoardManageService bms = new BoardManageServiceImp();
    private BoardService bs = new BoardServiceImp();

    
    private CategoryService categoryService = new CategoryServiceImp();
	private BoardService boardService = new BoardServiceImp();
    private List<Category> categoryList;
    private ArrayList<Board> boardList;
    
    
    private Scanner sc = new Scanner(System.in);
    private PrintService ps = new PrintServiceImp();
    private final int EXIT = 0;
    
	@Override
    public void add() {
		System.out.println("============= 게시판 등록 =============");
		// 카테고리-게시판 출력
		boardPrint();
		
		System.out.println("====================================");
		System.out.println("[이전으로 돌아가려면 0을 입력하세요]");
		
		// 카테고리 입력받기
		Category selectedCate = inputCategory();
		if(selectedCate == null) {
			return;
		}
		
		System.out.print("추가할 게시판 명 : ");
        String inputBoardName = sc.next();
        Board board = new Board(inputBoardName, selectedCate.getC_num());
        if(bms.add(board)) {
        	System.out.println("게시판 추가가 완료되었습니다.");
        }else {
			System.out.println("게시판 추가를 실패하였습니다.");
		}
    }
	
	// 카테고리를 입력 받는 메서드
	private Category inputCategory() {
		String categoryInput = "";

		do {
			try {
				// 카테고리 이름과 해당 카테고리 번호 입력
				System.out.print("카테고리 이름 입력: ");
				categoryInput = sc.nextLine();
				if(categoryInput.equals("0")) {
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요");
			}

			Category tmp = new Category(categoryInput);

			// 입력받은 카테고리가 존재하지 않을 경우
			if (!categoryList.contains(tmp)) {
				System.out.println("\n해당 카테고리가 존재하지 않습니다. 다시 입력해주세요.");
			} else {
				// 존재하는 경우 해당 카테고리 반환
				for (int i = 0; i < categoryList.size(); i++) {
					if (categoryList.get(i).equals(tmp)) {
						int idx = categoryList.indexOf(tmp);

						return categoryList.get(idx);
					}
				}

			}
		} while (!categoryInput.equals(EXIT + ""));

		return null;

	}
	
	private void boardPrint() {
		categoryList = categoryService.getAllCategory();

		if (categoryList == null || categoryList.size() == 0) {
			System.out.println("등록된 카테고리가 없습니다.");
			return;
		}
		// System.out.println(categoryList);
		// 카테고리가 있을 경우 카테고리 출력
		for (Category tmpCate : categoryList) {
			System.out.println("---" + tmpCate.getCName() + "---");

			// 특정 카테고리의 게시판 리스트를 불러오기
			ArrayList<Board> boardList = bs.selectBoard(tmpCate.getCNum());

			if (boardList == null || boardList.size() == 0) {
				System.out.println("(빈 카테고리)");
				continue; // 아래 코드를 실행하지 않고, 다음 단계 반복문 실행
			}

			for (int j = 0; j < boardList.size();) {
				Board tmpBoard = boardList.get(j);
				System.out.println("[" + ++j + "] " + tmpBoard.getbName());
			}
			System.out.println("\n");

		}
	}

	@Override
    public void update() {
		System.out.println("============= 게시판 수정 =============");
		
		// 카테고리-게시판 출력
		boardPrint();
		
		System.out.println("====================================");
		System.out.println("[이전으로 돌아가려면 0을 입력하세요]");
		
		// 카테고리 입력받기
		Category selectedCate = inputCategory();
		
		if(selectedCate == null) {
			return;
		}
		
		// 게시판 입력받기
		System.out.print("수정할 게시판 번호 입력: ");
		Board selectedBoard = inputBoard(selectedCate.getCNum());
		
		if(selectedBoard == null) {
			return;
		}
		
		System.out.print("수정할 게시판 명 : ");
		String newBoardName = sc.nextLine();
		sc.nextLine();
		
		Board newBoard = new Board(selectedBoard.getB_num(), newBoardName);
		
		if(bms.update(newBoard)) {
        	System.out.println("게시판 수정이 완료되었습니다.");
        }else {
			System.out.println("게시판 수정을 실패하였습니다.");
		}
		
    }

    @Override
    public void delete() {
    	System.out.println("============= 게시판 삭제 =============");
    	
    	// 카테고리-게시판 출력
		boardPrint();
		
		System.out.println("====================================");
		System.out.println("[이전으로 돌아가려면 0을 입력하세요]");
		
		// 카테고리 입력받기
		Category selectedCate = inputCategory();
		
		if(selectedCate == null) {
			return;
		}
		
		// 게시판 입력받기
		System.out.print("삭제할 게시판 번호 입력: ");
		Board selectedBoard = inputBoard(selectedCate.getCNum());
		if(selectedBoard == null) {
			return;
		}
		bms.deletePosts(selectedBoard.getB_num());
		if(bms.delete(selectedBoard.getB_num())) {
        	System.out.println("게시판 삭제가 완료되었습니다.");
        }else {
			System.out.println("게시판 삭제를 실패하였습니다.");
		}
    }
    
    // 게시판을 입력받는 메서드
 	private Board inputBoard(int cNum) {
 		int boardInput = -1;
 		boardList = boardService.selectBoard(cNum);

 		do {

 			try {
 				boardInput = sc.nextInt() - 1;
 				//sc.nextLine();


 			} catch (InputMismatchException e) {
 				System.out.println("잘못된 입력입니다. 다시 입력해주세요");
 			}

 			try {
 				// 존재할 경우, 해당 게시판의 고유 게시판 번호 리턴
 				// System.out.println(boardList.get(boardInput));
 				if(boardInput == -1) {
 					break;
 				}
 				return boardList.get(boardInput);

 			} catch (IndexOutOfBoundsException e) {
 				System.out.println("\n해당 게시판 번호가 존재하지 않습니다. 다시 입력해주세요.");
 			}

 		} while (boardInput != EXIT);

 		return null;
 	}
}
