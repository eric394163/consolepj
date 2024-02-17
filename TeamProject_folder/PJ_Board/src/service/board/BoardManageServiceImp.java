package service.board;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.BoardDB;
import db.CategoryDB;
import model.Board;

public class BoardManageServiceImp implements BoardManageService {

    private BoardDB boardDB;
    private Board board;

    public BoardManageServiceImp() {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream;
        SqlSession session;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sessionFactory.openSession(true);
            boardDB = session.getMapper(BoardDB.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(Board board) {
    	if(board == null || board.getB_name() == null) {
			return false;
		}
		return boardDB.addBoard(board);
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update(String inputBoardName, String inputUpdateBoardName) {
        Map<String, Object> params = new HashMap<>();
        params.put("oldCategoryName", inputBoardName);
        params.put("newCategoryName", inputUpdateBoardName);
        boardDB.updateBoard(params);
    }

}
