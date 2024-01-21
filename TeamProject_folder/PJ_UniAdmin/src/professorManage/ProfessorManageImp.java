/* To-do
 * 1. toString, equals()<조건 생각도 하시고... Overriding
 * 2. lecture는 아직 미개발이니까 나중에 개발하기!
 * 3. printProf 만들어서 잘 추가되는지 확인하기
 * 4. 이미 있는 교수인지 확인하는 메서ㄷ ManageUni에 만들기 (isDupProf< 교수가 1명도 없을 때 처리)
 * 
 * */

package professorManage;

import java.util.Scanner;

import model.ManageUni;
import model.Professor;
import service.display.DisplayService;
import service.display.DisplayServiceImp;
import service.print.PrintService;
import service.print.PrintServiceImp;

public class ProfessorManageImp implements ProfessorManage {

	DisplayService ds = new DisplayServiceImp();
	PrintService ps = new PrintServiceImp();
	private Scanner sc = new Scanner(System.in);
	private final int selectModel = 4;
	
    @Override
    public void addProfessor(ManageUni manageUni) {
        Professor newProfessor = manageUni.createProf();
        manageUni.addProfessor(newProfessor);
        manageUni.printProfessor();
    }

    @Override
    public void updateProfessor(ManageUni manageUni) {
    	/*
    	manageUni.printProfessor();
        System.out.print("수정할 교수 교번 : ");
        int profNum = sc.nextInt();
        if(manageUni.isDupProf(profNum)) { //있으면
        	manageUni.updateProfessor(profNum);
        	manageUni.printProfessor();
        }else {							   //없으면
        	System.out.println("등록되지 않은 교수입니다.");
        }
        */
    	
    	ds.Display(manageUni, selectModel,
                () -> ps.printBackNextUpdateExit(),  
                () -> manageUni.updateProfessor()); 
    }

    @Override
    public void deleteProfessor(ManageUni manageUni) {
    	ds.Display(manageUni, selectModel,
                () -> ps.printBackNextDeleteExit(),
                () -> manageUni.deleteProfessor());
    }

}
