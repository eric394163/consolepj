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

    public void addDepartment(String inputDepartment) {
        if (inputDepartment != null) {
            this.departments.add(new Department(inputDepartment));
            System.out.println(inputDepartment + " 추가 완료");
        } else {
            System.out.println("잘못된 입력");
        }

    }

}
