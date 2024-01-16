package model;

import java.util.List;

public class Student {
    String stdName;
    int grade;
    int studentId;
    String department;
    List<Lecture> lectureList;

    public Student(String stdName, int grade, int studentId, String department, List<Lecture> lectureList) {
        this.stdName = stdName;
        this.grade = grade;
        this.studentId = studentId;
        this.department = department;
        this.lectureList = lectureList;
    }

}
