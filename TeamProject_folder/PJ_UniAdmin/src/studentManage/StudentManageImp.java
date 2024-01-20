/* To-do
 * 

 * 
 * */

package studentManage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Department;
import model.Lecture;
import model.ManageUni;
import model.Student;

public class StudentManageImp implements StudentManage {
    private Scanner sc = new Scanner(System.in);

    private final int selectModel = 5;

    @Override
    public void addStudent(ManageUni manageUni) {
        Student newStudent = manageUni.createStd();
        manageUni.addStudent(newStudent);
        manageUni.printStudent();
    }

    @Override
    public void updateStudent(ManageUni manageUni) {
        manageUni.printStudent();
        System.out.print("수정할 학생 학번 입력 :");
        int oldStudentId = sc.nextInt();
        if (!manageUni.isDupStd(oldStudentId)) { // 등록되지 않은 학생일 경우
            System.out.println("등록되지 않은 학생입니다.");
            return; // 재입력 받는 코드 작성 필요함
        }
        Student newStudent = new Student(oldStudentId);

        System.out.print("새로운 학생 정보 입력 :");
        int inputUpdateStudent = sc.nextInt();

        manageUni.updateStudent(oldStudentId, newStudent);
    }

    @Override
    public void deleteStudent(ManageUni manageUni) {
        System.out.print("삭제할 학생 학번 입력 :");
        String inputDeleteStudent = sc.next();

        manageUni.deleteStudent(inputDeleteStudent);
    }

}
