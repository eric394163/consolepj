package model;

import java.util.ArrayList;
import java.util.List;

public class ManageUni {
    private List<Course> courses;
    private List<Lecture> lectures;
    private List<Professor> professors;
    private List<Student> students;
    private List<Department> departments;

    public ManageUni() {
        this.departments = new ArrayList<>();
    }

    // 과
    // =====================================================================================================================
    // 추가
    public void addDepartment(String inputDepartment) {
        if (inputDepartment != null) {
            this.departments.add(new Department(inputDepartment));
            System.out.println(inputDepartment + "과 추가 완료");
        } else {
            System.out.println("잘못된 입력.");
        }
    }

    // 수정
    public void updateDepartment(String oldDepartment, String newDepartmentName) {
        if (oldDepartment != null && newDepartmentName != null) {
            for (int i = 0; i < departments.size(); i++) {
                if (departments.get(i).getDepartmentName().equals(oldDepartment)) {
                    departments.set(i, new Department(newDepartmentName));
                    System.out.println(oldDepartment + "가 " + newDepartmentName + "으로 수정되었습니다.");
                    return;
                }
            }
            System.out.println(oldDepartment + "와 일치하는 과를 찾을 수 없습니다.");
        } else {
            System.out.println("잘못된 입력");
        }
    }

    // 삭제
    public void deleteDepartment(String deleteDepartment) {
        if (deleteDepartment != null) {
            for (int i = 0; i < departments.size(); i++) {
                if (departments.get(i).getDepartmentName().equals(deleteDepartment)) {
                    departments.remove(i);
                    System.out.println(deleteDepartment + "가 삭제 되었습니다.");
                    return;
                }
            }
            System.out.println(deleteDepartment + "와 일치하는 과를 찾을 수 없습니다.");
        } else {
            System.out.println("잘못된 입력");
        }
    }

}
