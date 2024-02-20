package service.category;

public interface CategoryManageService {
    void add(String inputCategoryName);

    void delete(String selectedCategory);

    void update(String inputCategoryName, String inputUpdateCategoryName);

}
