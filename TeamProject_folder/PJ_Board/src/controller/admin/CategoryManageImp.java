package controller.admin;

import java.util.List;
import java.util.Scanner;

import model.Category;
import service.category.CategoryManageService;
import service.category.CategoryManageServiceImp;
import service.category.CategoryServiceImp;

import service.print.PrintService;
import service.print.PrintServiceImp;
import service.category.CategoryService;

public class CategoryManageImp implements CategoryManage {

    private CategoryManageService cms = new CategoryManageServiceImp();
    private CategoryService cs = new CategoryServiceImp();
    private Scanner sc = new Scanner(System.in);
    private PrintService ps = new PrintServiceImp();

    @Override
    public void add() {
        System.out.print("추가할 카테고리 명 : ");
        String inputCategoryName = sc.next();
        cms.add(inputCategoryName);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

}
