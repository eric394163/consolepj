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

public class ProfessorManageImp implements ProfessorManage {

	private Scanner sc = new Scanner(System.in);
	
    @Override
    public void addProfessor(ManageUni manageUni) {
        Professor newProfessor = manageUni.createProf();
        manageUni.addProfessor(newProfessor);
        manageUni.printProfessor();
    }

    @Override
    public void updateProfessor(ManageUni manageUni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProfessor'");
    }

    @Override
    public void deleteProfessor(ManageUni manageUni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProfessor'");
    }

}
