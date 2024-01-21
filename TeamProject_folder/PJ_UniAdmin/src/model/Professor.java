package model;

import java.util.List;

public class Professor {

    String profName;

    List<Lecture> lectureList;

    public Professor(String profName, List<Lecture> lectureList) {
        this.profName = profName;
        this.lectureList = lectureList;
    }

}
