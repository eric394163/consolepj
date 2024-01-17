package departmentManage;

import java.util.Scanner;

import model.ManageUni;

public class DepartmentManageImp implements DepartmentManage {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void addDepartment(ManageUni manageUni) {
        System.out.print("추가할 과 입력 :");
        String inputDepartment = sc.next();
        manageUni.addDepartment(inputDepartment);

    }

    @Override
    public void updateDepartment(ManageUni manageUni) {

    }

    @Override
    public void deleteDepartment(ManageUni manageUni) {

    }

}
