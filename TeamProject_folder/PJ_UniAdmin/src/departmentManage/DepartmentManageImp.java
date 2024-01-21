package departmentManage;

import java.util.Scanner;

import model.ManageUni;

public class DepartmentManageImp implements DepartmentManage {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void addDepartment(ManageUni manageUni) {
        System.out.print("추가할 과 입력 :");
        String inputAddDepartment = sc.next();
        manageUni.addDepartment(inputAddDepartment);

    }

    @Override
    public void updateDepartment(ManageUni manageUni) {
        System.out.print("수정할 과 입력 :");
        String inputOldDepartment = sc.next();
        System.out.print("새로운 과 입력 :");
        String inputUpdateDepartment = sc.next();

        manageUni.updateDepartment(inputOldDepartment, inputUpdateDepartment);

    }

    @Override
    public void deleteDepartment(ManageUni manageUni) {
        System.out.print("삭제할 과 입력 :");
        String inputDeleteDepartment = sc.next();

        manageUni.deleteDepartment(inputDeleteDepartment);

    }

}
