package db;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import model.Board;

public interface BoardDB {
	ArrayList<Board> selectBoard(@Param("c_num")int c_num);

	//void addBoard(String inputBoardName, int cNum);

	void updateBoard(Map<String, Object> params);

	boolean addBoard(@Param("board")Board board);

	boolean deleteBoard(@Param("b_num")int b_num);

	void deletePosts(@Param("b_num")int b_num);

	boolean updateBoard(@Param("board")Board newBoard);

//	boolean isBoard(@Param("b_name")String b_name);
}
