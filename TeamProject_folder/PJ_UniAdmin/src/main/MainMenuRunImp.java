package main;

import java.util.Scanner;

import courseManage.CourseManage;
import departmentManage.DepartmentManage;
import lectureManage.LectureMange;
import model.ManageUni;
import professorManage.ProfessorManage;
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
    private ProfessorManage pfm;
    private LectureMange lm;

    public MainMenuRunImp(ManageUni manageUni, PrintService ps, SelectMenu sm, CourseManage cm, DepartmentManage dm,
            StudentManage stm, ProfessorManage pfm, LectureMange lm) {
        this.manageUni = manageUni;
        this.ps = ps;
        this.sm = sm;
        this.cm = cm;
        this.dm = dm;
        this.stm = stm;
        this.pfm = pfm;
        this.lm = lm;
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
        System.out.println("===== 강의 관리 =====");
        ps.printAddUpdDel();
        int input = sc.nextInt();
        sm.selectMenu(input,
                () -> lm.addLecture(manageUni),
                () -> lm.updateLecture(manageUni),
                () -> lm.deleteLecture(manageUni));

    }

    @Override
    public void professorManager() {
        System.out.println("===== 교수 관리 =====");
        ps.printAddUpdDel();
        int input = sc.nextInt();
        sm.selectMenu(input,
                () -> pfm.addProfessor(manageUni),
                () -> pfm.updateProfessor(manageUni),
                () -> pfm.deleteProfessor(manageUni));
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
                () -> dm.addDepartment(manageUni),
                () -> dm.updateDepartment(manageUni),
                () -> dm.deleteDepartment(manageUni));

    }

}
