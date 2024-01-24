package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import service.display.DisplayService;
import service.display.DisplayServiceImp;

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
		this.lectures = new ArrayList<Lecture>();
	}

	// 강좌추가

	public void addCourse(String inputCourse) {
		System.out.print("추가할 강좌의 이름 : ");
		String courseName = sc.next();

		System.out.print("추가할 강좌의 코드 : ");
		int courseCode = sc.nextInt();

		System.out.print("추가할 강좌의 시간 : ");
		int courseTime = sc.nextInt();
	}

	// 강의
	// =====================================================================================================================
	// 추가

	public void addLecture(String lectureName, int lectureNum, String lectureProf, int setMidscore, int setFinalScore,
			int setAttendanceScore, int setProjectScore) {
		if (lectureNum != 0) {
			Lecture newLectrue = new Lecture(lectureName, lectureNum, lectureProf, setMidscore, setFinalScore,
					setAttendanceScore, setProjectScore);
			if (!lectures.contains(newLectrue)) {
				this.lectures.add(newLectrue);
				System.out.println(lectureName + "강의 추가 완료");
			} else {
				System.out.println("중복된 강의");
			}

		} else {
			System.out.println("잘못된 입력.");
		}
	}

	public void updateLecture() {
		System.out.print("수정할 번호 입력 : ");
		int inputNum = sc.nextInt() - 1;
		Lecture updateLecture = lectures.get(inputNum);

		// Course selectCourse = manageUni.selectCourse();
		// String lectureName = selectCourse.getCourseName();
		// int lectureNum = selectCourse.getCourseNum();
		String lectureName = "임시수정";
		int lectureNum = 152;
		System.out.print("교수 이름 : ");
		String profName = sc.next();
		System.out.print("중간고사 점수 : ");
		int middleScore = sc.nextInt();
		System.out.print("기말고사 점수 : ");
		int fianlScore = sc.nextInt();
		System.out.print("출석 점수 : ");
		int attendanceScore = sc.nextInt();
		System.out.print("과제 점수: ");
		int projectScore = sc.nextInt();
		Lecture newLecture = new Lecture(profName, inputNum, profName, middleScore, fianlScore, attendanceScore,
				projectScore);
		if (lectures.get(inputNum) != null && newLecture != null) {
			for (int i = 0; i < lectures.size(); i++) {
				if (lectures.get(i).getLectureName().equals(updateLecture.getLectureName())) {
					lectures.set(i, newLecture);
					System.out.println(
							updateLecture.getLectureName() + "가 " + newLecture.getLectureName() + "으로 수정되었습니다.");
					return;
				}
			}
			System.out.println(updateLecture.getLectureName() + "와 일치하는 강의를 찾을 수 없습니다.");
		} else {
			System.out.println("잘못된 입력");
		}
	}

	public void deleteLecture() {
		System.out.print("삭제할 번호 입력 :");
		int inputNum = sc.nextInt() - 1;
		Lecture deleteLecture = lectures.get(inputNum);

		if (deleteLecture != null) {
			for (int i = 0; i < departments.size(); i++) {
				if (lectures.get(i).getLectureName().equals(deleteLecture.getLectureName())) {
					lectures.remove(i);
					System.out.println(deleteLecture.getLectureName() + "가 삭제 되었습니다.");
					return;
				}
			}
			System.out.println(deleteLecture.getLectureName() + "와 일치하는 과를 찾을 수 없습니다.");
		} else {
			System.out.println("잘못된 입력");
		}

	}

	public void printLecture(int startIndex, int pageSize) {
		if (departments.isEmpty()) {
			System.out.println("비어있음");
			return;
		}

		int endIndex = Math.min(startIndex + pageSize, lectures.size());
		for (int i = startIndex; i < endIndex; i++) {
			Lecture lecture = lectures.get(i);
			System.out.println(
					(i + 1) + "." + "||" + lecture.getLectureName());
		}
	}

	public int returnLectSize() {
		return lectures.size();

	}

	// 과
	// =====================================================================================================================
	// 추가
	public void addDepartment(String inputDepartment) {
		if (inputDepartment != null) {
			Department newDepartment = new Department(inputDepartment);
			if (!departments.contains(newDepartment)) {
				this.departments.add(newDepartment);
				System.out.println(inputDepartment + "과 추가 완료");
			} else {
				System.out.println("중복된 과");
			}
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

	// 선택
	public Department selectDepartment() {
		System.out.print("선택할 번호 입력 :");
		int inputNum = sc.nextInt() - 1;
		Department selectDepartment = departments.get(inputNum);
		return selectDepartment;
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
	 * 1. 학생 정보 수정 기능
	 * 학생 정보 수정 기능
	 * - 수강 정보 이전하기 (대입연산자 쓰면 될듯?)
	 * - 수강 신청 기록 이전 여부의 조건 (전과했을 때?)
	 * 
	 * 2. 학생 수정/삭제에서 index로 선택할 수 있게 하기
	 */

	/*
	 * 이번에 한 일...
	 * 1. develop 브랜치에서 pull해왔는데, ManageUni의 학생 부분 코딩해놓은게 다 사라져있었음,,,
	 * 그래서 이전 커밋 로그에서 복붙해왔음.... 교수 추가/수정/삭제 기능은 저장이 되어있는 것을 보아
	 * 교수 코드를 머지하는 과정에서 날아간 것이 아닌가 싶음. 일단 코드 복구 완료했고 발견된 문제 없음!
	 * (pr을 했다가 revert했다가... 문제 생기면 알려주시길)
	 * 
	 * 2. 학생 관리 과정에서 유저가 잘못 입력한 값 처리하는 코드 모두 끝냄.
	 * 반복문 말고 더 효율적인 방법이 있을까 검색해봤는데 외부 라이브러리 이용하기 등이 나와서 그냥 반복문으로 함...
	 * 좀 더 효율적인 방법이 있을까?
	 * 
	 * 3. 학생 추가/수정/삭제 전 사전조건(학과 등록 여부 및 최소 1명의 학생이 있는지 여부) 충족 여부 검사하는 코드 추가
	 * 
	 * 4. 예쁘게 전체 출력 되도록 하는 코드 추가(미완, todo참고)
	 * 
	 * 5. 교수 toString에 오타 있어서 수정함
	 * 
	 * 
	 */

	// 새로운 학생 개체 생성
	public Student createStd() {
		int studentId = 0, grade = 0;
		String stdName = "", departmentName = "";
		if (departments.size() < 1) { // 학과란이 비어있을 경우
			System.out.println("학생을 등록하려면 최소 1개의 학과가 사전에 등록되어야합니다. 학과를 먼저 등록해주세요.");
			return null;
		}
		while (true) {
			try {
				System.out.print("학번: ");
				studentId = sc.nextInt();
				sc.nextLine();

				if (studentId < 100000) {
					System.out.println("학번은 6자리 이상이어야합니다. 다시 입력해주세요.");
					continue;
				}

				// 중복 확인하기(중복이 아닐 경우 탈출)
				if (!isDupStd(studentId)) {
					break;
				}
				System.out.println("이미 존재하는 학번입니다. 다시 입력해주세요. ");

			} catch (Exception e) {
				// e.printStackTrace();
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
			}
		}

		System.out.print("이름: ");
		stdName = sc.next();

		while (true) {
			try {
				System.out.print("학년: ");
				grade = sc.nextInt();
				sc.nextLine();
				if (grade > 1 & grade < 4) {
					break;
				}
				System.out.println("1~4 학년만 설정할 수 있습니다.\n다시 입력해주세요. ");
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
			}

		}

		A: while (true) {
			try {
				System.out.print("학과: ");
				departmentName = sc.next();
				for (int i = 0; i < departments.size(); i++) {
					if (departments.get(i).getDepartmentName().equals(departmentName)) {
						break A; // 학과 입력 무한 반복문 종료
					}
				}
				System.out.println(departmentName + "와 일치하는 과를 찾을 수 없습니다.");
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
			}

		}

		// 입력값이 유효한지 확인하기
		// (학과가 이미 등록이 되어있는 건지 아닌지... 근데 이건 학과 부분 개발한거 가져오면 될듯?)
		Department Dep = new Department(departmentName);

		Student newStudent = new Student(studentId, stdName, grade, Dep);
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

	// 학생목록 단순 전체 조회
	// public void printStudent() {
	// System.out.println("\n\n\n\n\n\n=====학생 목록 출력=====\n");
	// students.stream().forEach((s)->System.out.println(s+"\n"));
	// }

	// 학생 리스트 길이 반화 메서드
	public int returnStdSize() {
		return students.size();

	}

	// 학생 출력 메서드
	public void printStudent(int startIndex, int pageSize) {
		if (students.isEmpty()) {
			System.out.println("비어있음");
			return;
		}

		int endIndex = Math.min(startIndex + pageSize, students.size());
		for (int i = startIndex; i < endIndex; i++) {
			Student student = students.get(i);
			System.out.println(
					(i + 1) + "." + "||" + student);
		}
	}

	// 추가
	public void addStudent(Student newStudent) {
		if (newStudent != null) {
			this.students.add(newStudent);
			System.out.println(newStudent.getStdName() + " 학생 추가 완료");
		} else {
			System.out.println("학생 추가 과정이 종료되었습니다.");
		}
	}

	// 수정
	public void updateStudent() {
		// printStudent();
		System.out.println("=============\n수정할 학생 학번 입력");
		int oldStudentId = sc.nextInt();
		if (!isDupStd(oldStudentId)) { // 등록되지 않은 학생일 경우
			System.out.println("등록되지 않은 학생입니다.");
			return; // 재입력 받는 코드 작성 필요함
		}
		Student oldStudent = new Student(oldStudentId); // 학번이 일치하는 객체를 찾기 위해 임시로 객체를 생성함
		int idx = students.indexOf(oldStudent); // 학번이 일치하는 학생 객체를 찾아 인덱스 반환
		oldStudent = students.get(idx);

		// 수정된 학생정보 객체 생성
		System.out.println("새로운 학생 정보 입력");
		Student reviseStd = createStd();

		// // 수강신청 목록 유지 여부 입력받기
		// // (전과를 하는 경우 수강신청 목록이 의미없어지는 경우가 있어서.)
		// // (아예 예전 객체와 과를 비교해서 다른 과면 이게 출력되도록 할까???)
		// System.out.print("수강신청 정보를 유지합니까? (Y/N)");
		// char yn = sc.next().charAt(0);
		// if(yn == 'Y' | yn=='y') {
		// // 기존 학생의 수강 정보를 가져와서(getLectureList) 수정된 학생 정보 객체에 이전하는 코드 추가 예정
		// }

		System.out.println("학생 삭제됨: " + students.remove(idx));
		students.add(reviseStd);
		System.out.println(oldStudent.getStdName() + "가 " + reviseStd.getStdName() + "으로 수정되었습니다.");
		return;
	}

	// 삭제
	public void deleteStudent() {
		System.out.print("삭제할 학생 학번 입력 :");
		while (true) {
			try {
				int deleteStudentId = sc.nextInt();
				sc.nextLine();

				for (int i = 0; i < students.size(); i++) {
					if (students.get(i).getStudentId() == deleteStudentId) {
						students.remove(i);
						System.out.println(deleteStudentId + "번 학생이 삭제 되었습니다.");
						return;
					}
				}
				System.out.println(deleteStudentId + "와 일치하는 학번을 가진 학생 찾을 수 없습니다.\n다시 입력");
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
			}

		}

	}

	// 학생 선택
	public Student selectStudent() {
		System.out.print("선택할 번호 입력 :");
		int inputNum = sc.nextInt() - 1;
		Student student = students.get(inputNum);
		return student;
	}

	// 교수
	// =====================================================================================================
	

	// 추가
	public void addProfessor(Professor newProfessor) {
		if (newProfessor != null) {
			this.professors.add(newProfessor);
			System.out.println(newProfessor.getProfName() + " 교수 추가 완료");
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}

	// 수정
	public void updateProfessor() {
		System.out.print("수정할 번호 입력 : ");
		int inputNum = sc.nextInt() - 1;
		Professor updateProfessor = professors.get(inputNum);

		if (!isDupProf(updateProfessor.getProfNum())) { // 없으면
			System.out.println("등록되지 않은 교수입니다.");
			return;
		}
		// 새로운 교수 이름, 교번, 연락처, 학과
		System.out.println("=======수정 내용=======");
		System.out.print("성명 : ");
		String profName = sc.next();
		String profPhoneNum = "";
		String pnPattern = "010-\\d{4}\\-\\d{4}"; // 정규 표현식
		while (true) {
			System.out.print("연락처 [ 예 : 010-0000-0000 ] : ");
			sc.nextLine();
			profPhoneNum = sc.nextLine();

			if (Pattern.matches(pnPattern, profPhoneNum)) {
				break;
			} else {
				System.out.println("잘못된 연락처 형식입니다. 다시 입력하세요");
			}
		}
		System.out.print("학과 : ");
		String profDepartment = sc.next();

		if (!isDupProf(updateProfessor.getProfNum())) { // 없으면
			System.out.println("등록되지 않은 교수입니다.");
			return;
		}

		Department Dep = new Department(profDepartment);
		departments.add(Dep);
		List<Lecture> lectureList = new ArrayList<Lecture>();

		professors.get(inputNum).setProfName(profName);
		professors.get(inputNum).setProfPhoneNum(profPhoneNum);
		professors.get(inputNum).setProfDepartment(profDepartment);
	}

	// 삭제
	public void deleteProfessor() {
		System.out.print("삭제할 번호 입력 :");
		int inputNum = sc.nextInt() - 1;
		Professor deleteProfessor = professors.get(inputNum);

		if (isDupProf(deleteProfessor.getProfNum())) { // 있으면
			professors.remove(inputNum);
			System.out.println(deleteProfessor + "가 삭제 되었습니다.");
			return;
		} else {
			System.out.println("잘못된 입력");
		}
	}

	// 교수 목록 출력
	public void printProfessor() {
		System.out.println("=====교수 목록 출력=====");
		professors.stream().forEach((s) -> System.out.println(s + "\n"));
	}

	// 이미 등록된 교수인지 확인
	public boolean isDupProf(int profNum) {
		if (professors.size() == 0) {
			return false;
		}
		for (int i = 0; i < professors.size(); i++) {
			Professor prof = professors.get(i);
			if (prof.getProfNum() == profNum) { // 문자열이 아니므로 == 비교
				// 일치하는 교슈ㅜ 있음
				return true;
			}
		}
		// 일치하는 교수 없음
		// System.out.println("일치하는 교수를 찾을 수 없습니다.");
		return false;
	}

	// 교수 리스트 길이 반화 메서드
	public int returnProfSize() {
		return professors.size();
	}

	// 교수 리스트 길이 반화 메서드

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
					(i + 1) + "." + "|| " + professor.getProfNum() + " || " + professor.getProfName() + " || "
							+ professor.getProfDepartment() + " || " + professor.getProfPhoneNum());
		}
	}

	// 교수 선택
	public Professor selectProfessor() {
		System.out.print("선택할 번호 입력 :");
		int inputNum = sc.nextInt() - 1;
		Professor professor = professors.get(inputNum);
		return professor;
	}

}
