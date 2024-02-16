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

}
