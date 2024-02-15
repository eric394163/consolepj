package db;

import java.util.List;
import java.util.Map;

import model.Category;

public interface CategoryDB {
    void addCategory(String inputCategoryName);

    void updateCategory(Map<String, Object> paramsparams);

    List<Category> getAllCategory();
}
