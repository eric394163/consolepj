package service.board;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.BoardDB;
import db.CategoryDB;
import model.Board;

public class BoardServiceImp implements BoardService {
	
	private BoardDB boarddb;
	
	public BoardServiceImp(){
		String resource = "src/config/mybatis-config.xml";
		
		InputStream inputStream;
		SqlSession session;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			boarddb = session.getMapper(BoardDB.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public ArrayList<Board> selectBoard(int c_num) {
		return boarddb.selectBoard(c_num);
	}

}
