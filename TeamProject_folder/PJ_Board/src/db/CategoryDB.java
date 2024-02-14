package db;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.Category;

public interface CategoryDB {
	
	// 카테고리 목록을 리턴하는 메서드
	ArrayList<Category> selectCategory();
	
}
