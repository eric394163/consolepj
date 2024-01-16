package service.print;

public class PrintServiceImp implements PrintService {

    @Override
    public void printMainMenu() {
        System.out.println("============= 관리 =============");
        System.out.println("1. 강좌 관리 ");
        System.out.println("2. 강의 관리 ");
        System.out.println("3. 교수 관리 ");
        System.out.println("4. 학생 관리 ");
        System.out.println("5. 수강 관리 ");
        System.out.println("6. 조회 ");
        System.out.println("==================================");
        System.out.print("메뉴 선택  :");
    }

    @Override
    public void printAddUpdDel() {
        System.out.println("1. 추가 ");
        System.out.println("2. 수정 ");
        System.out.println("3. 삭제 ");
    }

}
