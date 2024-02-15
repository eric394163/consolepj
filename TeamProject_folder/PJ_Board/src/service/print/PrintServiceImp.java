package service.print;

public class PrintServiceImp implements PrintService {

    @Override
    public void printMainMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printMainMenu'");
    }

    @Override
    public void printBackNextUpdateExit() {
        System.out.println("================================================");
        System.out.println("[ 이전 : 1 ] [ 다음 : 2 ] [ 수정 : 3 ] [ 종료 : 0 ]");
        System.out.println("================================================");
        System.out.print("선택 : ");
    }
}
