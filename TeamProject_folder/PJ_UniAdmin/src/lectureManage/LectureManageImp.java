package lectureManage;

import java.util.Scanner;

import model.Course;
import model.Department;
import model.Lecture;
import model.ManageUni;
import model.Professor;
import service.display.DisplayService;
import service.display.DisplayServiceImp;
import service.print.PrintService;
import service.print.PrintServiceImp;

public class LectureManageImp implements LectureMange {
    private Scanner sc = new Scanner(System.in);

    DisplayService ds = new DisplayServiceImp();
    PrintService ps = new PrintServiceImp();

    private final int selectModel = 2;

    @Override
    public void addLecture(ManageUni manageUni) {
        ds.Display(manageUni, 1,
                () -> ps.printBackNextExit());
        Course selectCourse = manageUni.selectCourse();
        String lectureName = selectCourse.getCourseName();
        int lectureNum = selectCourse.getCourseNum();
        System.out.print("교수 목록");
        ds.Display(manageUni, 4,
                () -> ps.printBackNextExit());
        Professor selectProf = manageUni.selectProfessor();
        String profName = selectProf.getProfName();
        System.out.print("중간고사 점수 : ");
        int middleScore = sc.nextInt();
        System.out.print("기말고사 점수 : ");
        int fianlScore = sc.nextInt();
        System.out.print("출석 점수 : ");
        int attendanceScore = sc.nextInt();
        System.out.print("과제 점수: ");
        int projectScore = sc.nextInt();

        manageUni.addLecture(lectureName, lectureNum, lectureName, middleScore, fianlScore, attendanceScore,
                projectScore);

    }

    @Override
    public void updateLecture(ManageUni manageUni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateLecture'");
    }

    @Override
    public void deleteLecture(ManageUni manageUni) {
        ds.Display(manageUni, selectModel,
                () -> ps.printBackNextDeleteExit(),
                () -> manageUni.deleteLecture());
    }

}
