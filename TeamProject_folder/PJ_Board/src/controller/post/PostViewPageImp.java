package controller.post;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import manager.UserManager;
import model.Board;
import model.Category;
import model.Post;
import service.board.BoardService;
import service.board.BoardServiceImp;
import service.category.CategoryService;
import service.category.CategoryServiceImp;
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
	private String boardName;


	private final int EXIT = 0;

	public PostViewPageImp(UserManager uManager, int selectedPnum, String boardName) {
		this.uManager = uManager;
		this.selectedPnum = selectedPnum;
		this.boardName = boardName;
	}

	@Override
	public void run() {
		Post post = ps.getPost(selectedPnum);
		Comment comment = 
		System.out.println("===============================");
		System.out.println("제목 : " + post.getP_title());
		System.out.println("게시판 : " + boardName);
		System.out.println("작성자 : " + post.getP_u_id());
		System.out.println("작성 날짜 : " + post.getP_date());
		System.out.println("내용 : " + post.getP_content());
		System.out.println("===============================");
		System.out.println("댓글");
		System.out.println("===============================");

	}



	private void displayAll() {
        int input = 0;
        int currentPage = 0;
        final int pageSize = 5; // 한 페이지에 들어갈 항목 수
        int totalPages = (myAccountBook.getAccountBookSize() + pageSize - 1) / pageSize; // 총 페이지 수 계산

        do {
            System.out.println("======= 가계부 (페이지 " + (currentPage + 1) + " / " + totalPages
                    + ") ==========");
            myAccountBook.printIncomeExpense(currentPage * pageSize, pageSize);

            System.out.println("===================================");
            System.out.println("[ 이전 : 1 ]  [ 다음 : 2 ] [ 종료 : 3 ]");
            System.out.println("===================================");
            System.out.print("입력 : ");
            input = sc.nextInt();

            if (input == 1 && currentPage > 0) {
                currentPage--;
            } else if (input == 2 && currentPage < totalPages - 1) {
                currentPage++;
            }
        } while (input != 3);

    }

}
