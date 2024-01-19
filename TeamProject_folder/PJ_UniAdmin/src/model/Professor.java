package model;

import java.util.List;

public class Professor {

    String profName;

    List<Lecture> lectureLists;

    public Professor(String profName, List<Lecture> lectureLists) {
        this.profName = profName;
        this.lectureLists = lectureLists;
    }

}
