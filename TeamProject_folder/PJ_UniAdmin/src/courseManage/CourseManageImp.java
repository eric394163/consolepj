package courseManage;

import java.util.Scanner;

import model.ManageUni;
import service.display.DisplayService;
import service.display.DisplayServiceImp;
import service.print.PrintService;
import service.print.PrintServiceImp;

public class CourseManageImp implements CourseManage {
    PrintService ps = new PrintServiceImp();
    DisplayService ds = new DisplayServiceImp();
    private Scanner sc = new Scanner(System.in);
    private final int selectModel = 1;

    @Override
    public void addCourse(ManageUni manageUni) {
        // 강좌 추가
        System.out.print("추가할 강좌 이름 : ");
        String courseName = sc.next();

        System.out.print("추가할 강좌 코드 : ");
        int courseCode = sc.nextInt();

        System.out.print("추가할 강좌 시간 : ");
        int courseTime = sc.nextInt();

        System.out.print("추가할 강좌 학점 : ");
        int gradePoint = sc.nextInt();

        manageUni.addCourse(courseName, courseCode, courseTime, gradePoint);
    }

    @Override
    public void updateCourse(ManageUni manageUni) {
        // 강좌 수정
        ds.Display(manageUni, selectModel,
                () -> ps.printBackNextUpdateExit(),
                () -> manageUni.updateCourse());
    }

    @Override
    public void deleteCourse(ManageUni manageUni) {
        // 강좌 삭제
        ds.Display(manageUni, selectModel,
                () -> ps.printBackNextDeleteExit(),
                () -> manageUni.deleteCourse());
    }

}
