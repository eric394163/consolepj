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
	
    @Override
    public void addStudent(ManageUni manageUni) {
    	System.out.println("추가할 학생 정보 입력");
	   Student newStudent = manageUni.createStd();
       manageUni.addStudent(newStudent);
//       manageUni.printStudent();
    }

    @Override
    public void updateStudent(ManageUni manageUni) {
    	manageUni.printStudent();
    	manageUni.updateStudent();
    }

    @Override
    public void deleteStudent(ManageUni manageUni) {
    	 manageUni.printStudent();
         manageUni.deleteStudent();
    }

}
