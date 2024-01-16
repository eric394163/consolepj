package main;

import java.util.Scanner;

import courseManage.CourseManage;
import model.ManageUni;
import service.print.PrintService;
import service.selectmenu.SelectMenu;

public class MainMenuRunImp implements MainMenuRun {

    private SelectMenu sm;
    private PrintService ps;
    private Scanner sc = new Scanner(System.in);
    private ManageUni manageUni;
    private CourseManage cm;

    public MainMenuRunImp(ManageUni manageUni, PrintService ps, SelectMenu sm, CourseManage cm) {
        this.manageUni = manageUni;
        this.ps = ps;
        this.sm = sm;
        this.cm = cm;
    }

    @Override
    public void courseManager() {

        System.out.println("===== 강좌 관리 =====");
        ps.printAddUpdDel();
        int input = sc.nextInt();
        sm.selectMenu(input,
                () -> cm.addCourse(manageUni), // 일단은 반환값 입력값이 없어도 되는 Runnable 함수형 인터페이스로 되어있음 
                () -> cm.updateCourse(manageUni), // 반화값이나 입력값이 생길 시 이에 맞는 함수형 인터페이스로 수정
                () -> cm.deleteCourse(manageUni));
    }

    @Override
    public void lectureManager() {

    }

    @Override
    public void professorManager() {

    }

    @Override
    public void studentManager() {

    }

    @Override
    public void lectureRegisManager() {

    }

    @Override
    public void displayManager() {

    }

}
