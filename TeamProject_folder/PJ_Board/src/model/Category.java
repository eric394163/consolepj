package model;

import java.util.Objects;

import lombok.Data;

@Data
public class Category {
    private int c_num; // 카테고리 번호
    private String c_name; // 카테고리 이름
    
    public Category(String c_name) {
    	this.c_name = c_name;
    }
    
	public String getCName() {
		return c_name;
	}

	public int getCNum() {
		// TODO Auto-generated method stub
		return c_num;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(c_name, other.c_name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(c_name);
	}

   
}
