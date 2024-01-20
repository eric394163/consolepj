package model;

import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Professor {

    String profName, profPhoneNum, profDepartment; //이름, 연락처(000-0000-0000로 입력받아야 함), 학과
    int profNum; //교번

    List<Lecture> lectureLists;

    public Professor(String profName, List<Lecture> lectureLists) {
        this.profName = profName;
        this.lectureLists = lectureLists;
    }

	@Override
	public String toString() {
		return "[교수 이름: " + profName + ", 연락처: " + profPhoneNum + ", 학과: "
				+ profDepartment + ", 교번: " + profNum + ", 강의목록: " + lectureList + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return profNum == other.profNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(profNum);
	}
    
}
