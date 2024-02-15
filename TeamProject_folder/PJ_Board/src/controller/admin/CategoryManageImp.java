package controller.admin;

import java.util.Scanner;

import service.category.CategoryManageService;
import service.category.CategoryManageServiceImp;

public class CategoryManageImp implements CategoryManage {

    private CategoryManageService cms = new CategoryManageServiceImp();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        System.out.print("추가할 카테고리 명 : ");
        String inputCategoryName = sc.next();
        cms.add(inputCategoryName);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

}
