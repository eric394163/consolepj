package db;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.Board;

public interface BoardDB {
	ArrayList<Board> selectBoard(@Param("c_num")int c_num);
}
