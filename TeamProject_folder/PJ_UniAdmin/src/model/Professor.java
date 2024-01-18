package model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Professor {

    String profName, profPhoneNum, profDepartment; //이름, 연락처(000-0000-0000로 입력받아야 함), 학과
    int profNum; //교번

    List<Lecture> lectureList;

	@Override
	public String toString() {
		return "Professor [profName=" + profName + ", profPhoneNum=" + profPhoneNum + ", profDepartment="
				+ profDepartment + ", profNum=" + profNum + ", lectureList=" + lectureList + "]";
	}

    
    
}
