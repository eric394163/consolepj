package model;

public class Course {
    String courseName; // 강좌 이름
    int courseCode; // 강좌 코드
    int courseTime; // 강좌 시간
    int gradePoint; // 강좌 학점

    public Course(String courseName, int courseCode, int courseTime, int gradePoint) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseTime = courseTime;
        this.gradePoint = gradePoint;
    }

}
