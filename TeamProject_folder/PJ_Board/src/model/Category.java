package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    private int cNum; // 카테고리 번호
    private String cName; // 카테고리 이름

}
