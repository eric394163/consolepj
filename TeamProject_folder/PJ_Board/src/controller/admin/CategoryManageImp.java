package controller.admin;

import java.util.List;
import java.util.Scanner;

import model.Category;
import service.category.CategoryManageService;
import service.category.CategoryManageServiceImp;
import service.category.CategoryServiceImp;
import service.category.CategoryService;

public class CategoryManageImp implements CategoryManage {

    private CategoryManageService cms = new CategoryManageServiceImp();
    private CategoryService cs = new CategoryServiceImp();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        System.out.print("추가할 카테고리 명 : ");
        String inputCategoryName = sc.next();
        cms.add(inputCategoryName);
    }

    @Override
    public void update() {
        List<Category> categoryList = cs.getAllCategory();
        displayCategory(categoryList);

        String selectedCategory = "";
        String updateCategory = "";

        while (true) {
            System.out.print("수정할 카테고리 명 : ");
            sc.nextLine();
            selectedCategory = sc.nextLine();
            if (selectedCategory.equals("1")) {
                continue;
            }
            if (selectedCategory.equals("0")) {
                break;
            }
            System.out.print("새로운 카테고리 명 : ");
            sc.nextLine();
            updateCategory = sc.nextLine();
            if (updateCategory.equals("1")) {
                continue;
            }
            if (updateCategory.equals("0")) {
                break;
            }
        }

        cms.update(selectedCategory, updateCategory);
        System.out.println(selectedCategory + "가 " + updateCategory + "로 수정되었습니다.");
    }

    @Override
    public void delete() {

    }

    private void displayCategory(List<Category> categoryList) {

        int input = 0;
        int currentPage = 0;
        final int pageSize = 5; // 한 페이지에 들어갈 항목 수
        int totalPages = (categoryList.size() + pageSize - 1) / pageSize; // 총 페이지 수 계산

        do {
            System.out.println("======= ( 카테고리 목록 " + (currentPage + 1) + " / " + totalPages
                    + ") ==========");
            printCategorys(currentPage * pageSize, pageSize, categoryList);

            System.out.println("===================================");
            System.out.println("[ 이전 : 1 ]  [ 다음 : 2 ]");
            System.out.println("[ 카테고리 선택 : 0 ]");
            System.out.println("===================================");
            System.out.print("입력 : ");
            input = sc.nextInt();

            if (input == 1 && currentPage > 0) {
                currentPage--;
            } else if (input == 2 && currentPage < totalPages - 1) {
                currentPage++;
            }
        } while (input != 0);

    }

    private void printCategorys(int startIndex, int pageSize, List<Category> categoryList) {
        if (categoryList.isEmpty()) {
            System.out.println("카테고리 없음");
            return;
        }

        int endIndex = Math.min(startIndex + pageSize, categoryList.size());
        for (int i = startIndex; i < endIndex; i++) {
            Category category = categoryList.get(i);
            System.out.println("카테고리 명 : " + category.getC_name());

        }
    }

}
