package service.board;

import model.Board;

public interface BoardManageService {
    //void add(String inputBoardName, int cNum);

    void delete();

    void update(String inputBoardName, String inputUpdateBoardName);

	boolean add(Board board);

}
