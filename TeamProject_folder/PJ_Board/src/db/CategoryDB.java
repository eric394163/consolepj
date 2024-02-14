package db;

import java.util.ArrayList;

import model.Category;

public interface CategoryDB {
	
	// 카테고리 목록을 불러오는 메서드
	ArrayList<Category> selectCategoryList();
	
}
