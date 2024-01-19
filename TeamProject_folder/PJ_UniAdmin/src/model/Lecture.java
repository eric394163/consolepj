package model;

public class Lecture {

    String lectureName; // 강의명 (학생, 교사)

    int lectureNum; // 강의 코드 ( 교사 )

    String lectureProf; // 강의 교수명

    // 교사가 설정하는 점수 분배 ( 40 40 20 )
    int setMidscore;
    int setFinalScore;
    int setAttendanceScore;
    int setProjectScore;

    // 학생 점수 입력 받는 곳
    int stdMidscore;
    int stdFinalscore;
    int stdAttendancescore;
    int stdProjectScore;

    // 학생관련 생성자
    public Lecture(String lectureName, int stdMidscore, int stdFinalscore, int stdAttendancescore,
            int stdProjectScore) {
        this.lectureName = lectureName;
        this.stdMidscore = stdMidscore;
        this.stdFinalscore = stdFinalscore;
        this.stdAttendancescore = stdAttendancescore;
        this.stdProjectScore = stdProjectScore;
    }

    // 교사관련 생성자
    public Lecture(String lectureName, int lectureNum, String lectureProf, int setMidscore, int setFinalScore,
            int setAttendanceScore, int setProjectScore) {
        this.lectureName = lectureName;
        this.lectureNum = lectureNum;
        this.lectureProf = lectureProf;
        this.setMidscore = setMidscore;
        this.setFinalScore = setFinalScore;
        this.setAttendanceScore = setAttendanceScore;
        this.setProjectScore = setProjectScore;
    }

}
