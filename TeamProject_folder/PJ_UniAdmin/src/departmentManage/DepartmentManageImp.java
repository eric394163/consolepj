package departmentManage;

import java.util.Scanner;

import model.ManageUni;
import service.display.DisplayService;
import service.display.DisplayServiceImp;
import service.print.PrintService;
import service.print.PrintServiceImp;

public class DepartmentManageImp implements DepartmentManage {
    private Scanner sc = new Scanner(System.in);
    PrintService ps = new PrintServiceImp();
    DisplayService ds = new DisplayServiceImp();
    private final int selectModel = 3;

    @Override
    public void addDepartment(ManageUni manageUni) {
        System.out.print("추가할 과 입력 :");
        String inputAddDepartment = sc.next();
        manageUni.addDepartment(inputAddDepartment); // 널, 중복 처리
    }

    @Override
    public void updateDepartment(ManageUni manageUni) {
        ds.Display(manageUni, selectModel,
                () -> ps.printBackNextUpdateExit(),  
                () -> manageUni.updateDepartment()); 

    }

    @Override
    public void deleteDepartment(ManageUni manageUni) {
        ds.Display(manageUni, selectModel,
                () -> ps.printBackNextDeleteExit(),
                () -> manageUni.deleteDepartment());

    }

}
