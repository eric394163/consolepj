package service.category;

public interface CategoryManageService {
    void add(String inputCategoryName);

    void delete();

    void update(String inputCategoryName, String inputUpdateCategoryName);

}
