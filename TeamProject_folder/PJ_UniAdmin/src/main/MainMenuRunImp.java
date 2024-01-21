package main;

import java.util.Scanner;

import courseManage.CourseManage;
import departmentManage.DepartmentManage;
import model.ManageUni;
import service.print.PrintService;
import service.selectmenu.SelectMenu;
import studentManage.StudentManage;

public class MainMenuRunImp implements MainMenuRun {

    private SelectMenu sm;
    private PrintService ps;
    private Scanner sc = new Scanner(System.in);
    private ManageUni manageUni;
    private CourseManage cm;
    private DepartmentManage dm;
    private StudentManage stm; // 학생 관리 클래스 추가

    public MainMenuRunImp(ManageUni manageUni, PrintService ps, SelectMenu sm, CourseManage cm, DepartmentManage dm, StudentManage stm) {
        this.manageUni = manageUni;
        this.ps = ps;
        this.sm = sm;
        this.cm = cm;
        this.dm = dm;
        this.stm = stm;
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
    }// 람다식에는 일반 지역변수가 들어갈 수 없기에 final로 바꿔서 넣어야 함

    @Override
    public void lectureManager() {

    }

    @Override
    public void professorManager() {

    }

    @Override
    public void studentManager() {
    	System.out.println("===== 학생 관리 =====");
        ps.printAddUpdDel();
        int input = sc.nextInt();
        sm.selectMenu(input,
                () -> stm.addStudent(manageUni), 
                () -> stm.updateStudent(manageUni), 
                () -> stm.deleteStudent(manageUni));
    }

    @Override
    public void lectureRegisManager() {

    }

    @Override
    public void displayManager() {

    }

    @Override
    public void departmentManager() {
        System.out.println("===== 과 관리 =====");
        ps.printAddUpdDel();
        int input = sc.nextInt();
        sm.selectMenu(input,
                () -> dm.addDepartment(manageUni), // 일단은 반환값 입력값이 없어도 되는 Runnable 함수형 인터페이스로 되어있음
                () -> dm.updateDepartment(manageUni), // 반화값이나 입력값이 생길 시 이에 맞는 함수형 인터페이스로 수정
                () -> dm.deleteDepartment(manageUni));
    }// 람다식에는 일반 지역변수가 들어갈 수 없기에 final로 바꿔서 넣어야 함

}
