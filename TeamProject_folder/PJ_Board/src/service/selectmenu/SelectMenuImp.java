package service.selectmenu;

public class SelectMenuImp implements SelectMenu {
    // 가변인자로 메서드들을 배열에 저장해서 배열 인덱스로 메서드 접근이 가능해짐 인덱스 접근이기에 입력값에 -1이 됨
    public void selectMenu(int input, Runnable... methods) {
        if (methods.length < input) {
            return;
        }
        if (input == 0) {
        	return;
        }
        if (methods[input - 1] != null) {
            methods[input - 1].run();
        }
    }

}
