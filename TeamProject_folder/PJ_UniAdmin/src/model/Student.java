/* To-do
 * 1. 수강중인 강의가 null이면 없다고 출력하는 람다식 만들기
 * 
 * */

package model;

import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Student {
	int studentId;
    String stdName;
    int grade;
    Department department;
    List<Lecture> lectureList;
    
    public Student(int studentId) {
    	this.studentId = studentId;
    }

    // 학번이 같으면 같은 학생으로 인식하도록 equals Overriding... (근데 의미가 있나? 코드 가독성이 좋다는 건 있긴할듯)
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return studentId == other.studentId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}

	@Override
	public String toString() {
		return "[학생 이름: " + stdName + ", 학년: " + grade + ", 학번: " + studentId + ", 학과: "
				+ department.getDepartmentName() + "]\n수강 중인 강의: " + lectureListPrint() ;
	}
	
	
// 필요 메서드 정의
// =====================================================================================================================
// 
	
	

//	수강 중인 강의를 모두 출력하는 메서드
	private String lectureListPrint() {
		if(this.lectureList == null) {
			return "수강 중인 강의 없음.";
		}
		
		 // 예쁘게 출력하기 위해 lecture에서 toString Override할 필요 있음.
		this.lectureList.stream().forEach(e->System.out.println(e));
		return null;
	}


	


    

}
