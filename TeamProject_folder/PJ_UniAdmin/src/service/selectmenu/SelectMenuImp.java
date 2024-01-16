package service.selectmenu;

public class SelectMenuImp implements SelectMenu {

    public void selectMenu(int input, Runnable... methods) {
        if (methods.length < input) {
            return;
        }
        if (methods[input - 1] != null) {
            methods[input - 1].run();
        }
    }

}
