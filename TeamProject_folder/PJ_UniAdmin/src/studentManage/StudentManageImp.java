/* To-do
 * 

 * 
 * */

package studentManage;

import java.util.Scanner;

import model.ManageUni;
import model.Student;
import service.display.DisplayService;
import service.display.DisplayServiceImp;
import service.print.PrintService;
import service.print.PrintServiceImp;

public class StudentManageImp implements StudentManage {
    private Scanner sc = new Scanner(System.in);
    PrintService ps = new PrintServiceImp();
    DisplayService ds = new DisplayServiceImp();
    private final int selectModel = 5;

    @Override
    public void addStudent(ManageUni manageUni) {
    	if(manageUni.returnDeptSize()<1) {
    		System.out.println("학생을 추가하기 위해선 학과가 최소 1개 등록되어 있어야 합니다. 학과를 먼저 등록해주세요.");
    		return;
    	}
        Student newStudent = manageUni.createStd();
        manageUni.addStudent(newStudent);
//        manageUni.printStudent();

    }

    
    @Override
    public void updateStudent(ManageUni manageUni) {
    	if(manageUni.returnStdSize()<1) {
    		System.out.println("등록되어있는 학생이 없습니다. 학생을 먼저 등록해주세요.");
    		return;
    	}
        ds.Display(manageUni, selectModel,
                () -> ps.printBackNextUpdateExit(),  
                () -> manageUni.updateStudent());   
    }

    @Override
    public void deleteStudent(ManageUni manageUni) {
    	if(manageUni.returnStdSize()<1) {
    		System.out.println("등록되어있는 학생이 없습니다. 학생을 먼저 등록해주세요.");
    		return;
    	}
    	ds.Display(manageUni, selectModel,
                () -> ps.printBackNextDeleteExit(),
                () -> manageUni.deleteStudent());

    }

}
