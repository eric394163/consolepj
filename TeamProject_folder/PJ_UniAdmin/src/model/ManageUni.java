package model;

import java.util.List;

public class ManageUni {
    private List<Course> courses;
    private List<Lecture> lectures;
    private List<Professor> professors;
    private List<Student> students;

    public void addCourse(Course courses) {
        this.courses.add(courses);
    }

}
