/* To-do
 * 1. toString, equals()<조건 생각도 하시고... Overriding
 * 2. lecture는 아직 미개발이니까 나중에 개발하기!
 * 3. printProf 만들어서 잘 추가되는지 확인하기
 * 4. 이미 있는 교수인지 확인하는 메서ㄷ ManageUni에 만들기 (isDupProf< 교수가 1명도 없을 때 처리)
 * 
 * */

package professorManage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.Department;
import model.Lecture;
import model.ManageUni;
import model.Professor;
import service.display.DisplayService;
import service.display.DisplayServiceImp;
import service.print.PrintService;
import service.print.PrintServiceImp;

public class ProfessorManageImp implements ProfessorManage {

    DisplayService ds = new DisplayServiceImp();
    PrintService ps = new PrintServiceImp();
    private ManageUni mu;
    private Scanner sc = new Scanner(System.in);
    private final int selectModel = 4;

    @Override
    public void addProfessor(ManageUni manageUni) {        
        // 교수 이름, 교번, 연락처, 학과
 		System.out.print("성명 : ");
 		String profName = sc.next();

 		int profNum = 0;
 		while (true) {
 			try {
 				System.out.print("교번: ");
 				profNum = sc.nextInt();
 				sc.nextLine();

 				if (profNum < 100000) {
 					System.out.println("교번은 6자리 이상이어야합니다. 다시 입력해주세요.");
 					continue;
 				}

 				// 중복 확인하기(중복이 아닐 경우 탈출)
 				if (!manageUni.isDupProf(profNum)) {
 					break;
 				}
 				System.out.println("이미 존재하는 교번입니다. 다시 입력해주세요. ");

 			} catch (Exception e) {
 				System.out.println("잘못된 입력입니다.");
 				sc.nextLine();
 			}
 		}
 		String profPhoneNum = "";
 		String pnPattern = "010-\\d{4}\\-\\d{4}"; // 정규 표현식
 		while (true) {
 			System.out.print("연락처 [ 예 : 010-0000-0000 ] : ");
 			profPhoneNum = sc.nextLine();

 			if (Pattern.matches(pnPattern, profPhoneNum)) {
 				break;
 			} else {
 				System.out.println("잘못된 연락처 형식입니다. 다시 입력하세요");
 			}
 		}
 		System.out.print("학과 : ");
 		String profDepartment = sc.next();

 		Department Dep = new Department(profDepartment);
 		//departments.add(Dep);
 		List<Lecture> lectureList = new ArrayList<Lecture>();

 		Professor newProfessor = new Professor(profName, profPhoneNum, profDepartment, profNum, lectureList);

        manageUni.addProfessor(newProfessor);
        manageUni.printProfessor();
    }


	@Override
    public void updateProfessor(ManageUni manageUni) {
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
