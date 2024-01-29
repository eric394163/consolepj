package service.print;

public class PrintServiceImp implements PrintService {

    @Override
    public void printMainMenu() {
        System.out.println("============= 관리 =============");
        System.out.println("1. 강좌 관리 ");
        System.out.println("2. 강의 관리 ");
        System.out.println("3. 과 관리 ");
        System.out.println("4. 교수 관리 ");
        System.out.println("5. 학생 관리 ");
        System.out.println("6. 종료 ");
        System.out.println("==================================");
        System.out.print("메뉴 선택  :");
    }

    @Override
    public void printAddUpdDel() {
        System.out.println("1. 추가 ");
        System.out.println("2. 수정 ");
        System.out.println("3. 삭제 ");
        System.out.println("===================");
        System.out.print("메뉴 선택 :");
    }

    @Override
    public void printBackNextExit() {
        System.out.println("===================================");
        System.out.println("[ 이전 : 1 ] [ 다음 : 2 ] [ 종료 : 0 ]");
        System.out.println("===================================");
        System.out.print("선택 : ");

    }

    @Override
    public void printBackNextDeleteExit() {
        System.out.println("================================================");
        System.out.println("[ 이전 : 1 ] [ 다음 : 2 ] [ 삭제 : 3 ] [ 종료 : 0 ]");
        System.out.println("================================================");
        System.out.print("선택 : ");
    }

    @Override
    public void printBackNextUpdateExit() {
        System.out.println("================================================");
        System.out.println("[ 이전 : 1 ] [ 다음 : 2 ] [ 수정 : 3 ] [ 종료 : 0 ]");
        System.out.println("================================================");
        System.out.print("선택 : ");
    }

}
