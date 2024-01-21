package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageUni {
	private Scanner sc = new Scanner(System.in);
	// 스캐너 추가했는데 별로인지?? (학생 개체 생성 코드 때문에)

	private List<Course> courses;
	private List<Lecture> lectures;
	private List<Professor> professors;
	private List<Student> students;
	private List<Department> departments;

	public ManageUni() {
		this.departments = new ArrayList<>();
		this.students = new ArrayList<Student>();
		this.professors = new ArrayList<Professor>();
	}

	// 과
	// =====================================================================================================================
	// 추가
	public void addDepartment(String inputDepartment) {
		if (inputDepartment != null) {
			this.departments.add(new Department(inputDepartment));
			System.out.println(inputDepartment + "과 추가 완료");
		} else {
			System.out.println("잘못된 입력.");
		}
	}

	// 수정
	public void updateDepartment() {
		System.out.print("수정할 번호 입력 : ");
		int inputNum = sc.nextInt() - 1;
		Department updateDepartment = departments.get(inputNum);
		System.out.print("새로운 과 입력 :");
		String newDepartment = sc.next();
		if (departments.get(inputNum) != null && newDepartment != null) {
			for (int i = 0; i < departments.size(); i++) {
				if (departments.get(i).getDepartmentName().equals(updateDepartment.getDepartmentName())) {
					departments.set(i, new Department(newDepartment));
					System.out.println(updateDepartment.getDepartmentName() + "가 " + newDepartment + "으로 수정되었습니다.");
					return;
				}
			}
			System.out.println(updateDepartment.getDepartmentName() + "와 일치하는 과를 찾을 수 없습니다.");
		} else {
			System.out.println("잘못된 입력");
		}
	}

	// 삭제
	public void deleteDepartment() {
		System.out.print("삭제할 번호 입력 :");
		int inputNum = sc.nextInt() - 1;
		Department deleteDepartment = departments.get(inputNum);

		if (deleteDepartment != null) {
			for (int i = 0; i < departments.size(); i++) {
				if (departments.get(i).getDepartmentName().equals(deleteDepartment.getDepartmentName())) {
					departments.remove(i);
					System.out.println(deleteDepartment.getDepartmentName() + "가 삭제 되었습니다.");
					return;
				}
			}
			System.out.println(deleteDepartment.getDepartmentName() + "와 일치하는 과를 찾을 수 없습니다.");
		} else {
			System.out.println("잘못된 입력");
		}
	}

	// 과 리스트 길이 반화 메서드
	public int returnDeptSize() {
		return departments.size();

	}

	// 과 출력 메서드
	public void printDepartment(int startIndex, int pageSize) {
		if (departments.isEmpty()) {
			System.out.println("비어있음");
			return;
		}

		int endIndex = Math.min(startIndex + pageSize, departments.size());
		for (int i = startIndex; i < endIndex; i++) {
			Department department = departments.get(i);
			System.out.println(
					(i + 1) + "." + "||" + department.getDepartmentName());
		}
	}

	// 학생
	// =====================================================================================================================
	/*
	 * To-do
	 * 
	 * 1. 잘못 입력받았을 경우 다시 입력받는 코드 참고하기
	 * - 모든 입력값이 유효한지 확인하기
	 * 2. 학생 정보 수정 기능
	 * - 수강 정보 이전하기 (대입연산자 쓰면 될듯?)

	 * 3. 학생 삭제 기능
	 */

	// 새로운 학생 개체 생성
	public Student createStd() {
		int studentId = 0;
		try {
			System.out.print("추가할 학생 정보 입력\n학번: ");
			studentId = sc.nextInt();
			sc.nextLine();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다. 다시 입력하세요: ");
		}

		// 중복, 잘못된 입력 처리하기
		if (isDupStd(studentId)) {
			System.out.println("이미 존재하는 학번입니다. 다시 입력해주세요: ");
			sc.next();
			studentId = sc.nextInt();
		}

		System.out.println("이름: ");
		String stdName = sc.next();

		System.out.println("학년: ");
		int grade = sc.nextInt();
		// 입력값이 유효한지 확인하기 (1~4)

		sc.nextLine();
		System.out.println("학과: ");
		String departmentName = sc.next();
		// 입력값이 유효한지 확인하기
		// (학과가 이미 등록이 되어있는 건지 아닌지... 근데 이건 학과 부분 개발한거 가져오면 될듯?)
		Department Dep = new Department(departmentName);
		List<Lecture> lectureList = new ArrayList<Lecture>(); // 새로운 수강 강좌 리스트 만들기

		Student newStudent = new Student(studentId, stdName, grade, Dep, lectureList);
		return newStudent;
	}

	// 이미 등록된 학생인 지 확인하는 메서드
	public boolean isDupStd(int studentId) {
		if (students.size() == 0) {
			return false;
		}
		for (int i = 0; i < students.size(); i++) {
			Student std = students.get(i);
			if (std.getStudentId() == (studentId)) {
				// 일치하는 학생이 있음.
				return true;
			}
		}
		// 일치하는 학생이 없음.
		return false;
	}

	// 학생 목록 조회
	public void printStudent() {
		System.out.println("\n\n\n\n\n\n=====학생 목록 출력=====\n");
		students.stream().forEach((s) -> System.out.println(s + "\n"));
		System.out.println("\n\n\n\n");
	}

	// 추가
	public void addStudent(Student newStudent) {
		if (newStudent != null) {
			this.students.add(newStudent);
			System.out.println(newStudent.getStdName() + " 학생 추가 완료");
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}

	// 수정
	public void updateStudent(int oldStudentId, Student newStudent) {
		if (newStudent != null) {
			if (isDupStd(oldStudentId)) {
				// students.set(i, newStudent);
				System.out.println(oldStudentId + "가 " + newStudent.getStdName() + "으로 수정되었습니다.");
				return;
			}

		}
		System.out.println(oldStudentId + "와 일치하는 학번을 가진 학생을 찾을 수 없습니다.");

	}

	// 삭제
	public void deleteStudent(String deleteStudent) {
		if (deleteStudent != null) {
			for (int i = 0; i < students.size(); i++) {
				if (departments.get(i).getDepartmentName().equals(deleteStudent)) {
					departments.remove(i);
					System.out.println(deleteStudent + "가 삭제 되었습니다.");
					return;
				}
			}
			System.out.println(deleteStudent + "와 일치하는 학번을 가진 학생 찾을 수 없습니다.");
		} else {
			System.out.println("잘못된 입력");
		}
	}

    
    //교수 =====================================================================================================
    
    
	public Professor createProf() {
		//교수 이름, 교번, 연락처, 학과
    	System.out.print("성명 : ");
    	String profName = sc.next();
    	System.out.print("교번 : ");
    	int profNum = sc.nextInt();
    	System.out.print("연락처 : ");
    	String profPhoneNum = sc.next();
    	System.out.print("학과 : ");
        String profDepartment = sc.next();
        
        Department Dep = new Department(profDepartment);
        departments.add(Dep);
        List<Lecture> lectureList = new ArrayList<Lecture>();
	    
		Professor newProfessor = new Professor(profName, profPhoneNum, profDepartment, profNum, lectureList);
		
		return newProfessor;
	}
	
	//추가
	public void addProfessor(Professor newProfessor) {
		
		if (newProfessor != null) {
            this.professors.add(newProfessor);
            System.out.println(newProfessor.getProfName() + " 교수 추가 완료");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
	}
	
	
	//수정
	public void updateProfessor() {
        System.out.print("수정할 번호 입력 : ");
		int inputNum = sc.nextInt() - 1;
		Professor updateProfessor = professors.get(inputNum);
		
        if(!isDupProf(updateProfessor.getProfNum())) { //없으면
        	System.out.println("등록되지 않은 교수입니다.");
        	return;
        }
		//새로운 교수 이름, 교번, 연락처, 학과
    	System.out.print("성명 : ");
    	String profName = sc.next();
    	System.out.print("연락처 : ");
    	String profPhoneNum = sc.next();
    	System.out.print("학과 : ");
        String profDepartment = sc.next();
        
        Department Dep = new Department(profDepartment);
        departments.add(Dep);
        List<Lecture> lectureList = new ArrayList<Lecture>();
        
		professors.get(inputNum).setProfName(profName);
		professors.get(inputNum).setProfPhoneNum(profPhoneNum);
		professors.get(inputNum).setProfDepartment(profDepartment);
	}
	
	
	//삭제
	public void deleteProfessor() {
		System.out.print("삭제할 번호 입력 :");
		int inputNum = sc.nextInt() - 1;
		Professor deleteProfessor = professors.get(inputNum);

		if(isDupProf(deleteProfessor.getProfNum())) { //있으면
			professors.remove(inputNum);
			System.out.println(deleteProfessor + "가 삭제 되었습니다.");
			return;
		} else {
			System.out.println("잘못된 입력");
		}
	}
	
	
	//교수 목록 출력
	public void printProfessor() {
		System.out.println("=====교수 목록 출력=====");
    	professors.stream().forEach((s)->System.out.println(s+"\n"));
	}
	
	// 이미 등록된 교수인지 확인
    public boolean isDupProf(int profNum) {
    	if(professors.size()==0) {
    		return false;
    	}
		 for (int i = 0; i < professors.size(); i++) {
			 Professor prof = professors.get(i);
	         if (prof.getProfNum() == profNum) { //문자열이 아니므로 == 비교
	        	 // 일치하는 교슈ㅜ 있음
	             return true;
	         }
	     }
		 // 일치하는 교수 없음
		 System.out.println("일치하는 교수를 찾을 수 없습니다.");
		 return false;
    }

    
    // 교수 리스트 길이 반화 메서드
 	public int returnProfSize() {
 		return professors.size();

 	}

 	// 교수 출력 메서드
 	public void printProfessor(int startIndex, int pageSize) {
 		if (professors.isEmpty()) {
 			System.out.println("비어있음");
 			return;
 		}

 		int endIndex = Math.min(startIndex + pageSize, professors.size());
 		for (int i = startIndex; i < endIndex; i++) {
 			Professor professor = professors.get(i);
 			System.out.println(
 					(i + 1) + "." + "|| " + professor.getProfNum() + " || " + professor.getProfName() + " || " + professor.getProfDepartment() + " || " + professor.getProfPhoneNum());
 		}
 	}

}
