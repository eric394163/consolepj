package controller.post;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import manager.UserManager;
import model.Board;
import model.Category;
import service.board.BoardService;
import service.board.BoardServiceImp;
import service.category.CategoryService;
import service.category.CategoryServiceImp;
import service.selectmenu.SelectMenu;
import service.selectmenu.SelectMenuImp;

public class PostInsertPageImp implements PostInsertPage {

    private Scanner sc = new Scanner(System.in);
    private SelectMenu sm = new SelectMenuImp();

    private final int EXIT = 0;
    
 
	public PostInsertPageImp(UserManager uManager, int bNum) {
		
	}


	@Override
	public void run() {
		int input = -1;
		System.out.println("게시글 작성 구현 예정");
		
		do {
			try{
				
			}catch(InputMismatchException e) {
				
			}
			
		}while(input != EXIT);
		
	}

}
