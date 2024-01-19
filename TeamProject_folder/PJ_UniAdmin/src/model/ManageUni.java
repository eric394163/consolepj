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
            System.out.println("잘못된 입력입니다.");
        }
    }

    // 수정
    public void updateDepartment(String oldDepartment, String newDepartmentName) {
        if (oldDepartment != null && newDepartmentName != null) {
            for (int i = 0; i < departments.size(); i++) {
                if (departments.get(i).getDepartmentName().equals(oldDepartment)) {
                    departments.set(i, new Department(newDepartmentName));
                    System.out.println(oldDepartment + "가 " + newDepartmentName + "으로 수정되었습니다.");
                    return;
                }
            }
            System.out.println(oldDepartment + "와 일치하는 과를 찾을 수 없습니다.");
        } else {
            System.out.println("잘못된 입력");
        }
    }

    // 삭제
    public void deleteDepartment(String deleteDepartment) {
        if (deleteDepartment != null) {
            for (int i = 0; i < departments.size(); i++) {
                if (departments.get(i).getDepartmentName().equals(deleteDepartment)) {
                    departments.remove(i);
                    System.out.println(deleteDepartment + "가 삭제 되었습니다.");
                    return;
                }
            }
            System.out.println(deleteDepartment + "와 일치하는 과를 찾을 수 없습니다.");
        } else {
            System.out.println("잘못된 입력");
        }
    }
    
    // 학생
    // =====================================================================================================================
    /* To-do
     *  
     * 1. 모든 입력값이 유효한지 확인하기
     *  - 잘못 입력받았을 경우 다시 입력받는 코드 참고하기
     *  - 메서드화 하기
     * 2. 학생 정보 수정 기능
	 * 	- 수강 정보 이전하기 (대입연산자 쓰면 될듯?)
	 *  - 수강 신청 기록 이전 여부의 조건 (전과했을 때?)
	 * 3. 학생 삭제 기능
     * */
    
    
    
    
    // 새로운 학생 개체 생성
    public Student createStd() {
    	int studentId=0;
    	try {
    		System.out.print("학번: ");
            studentId = sc.nextInt();
    	    sc.nextLine();
    	}catch(Exception e) {
    		System.out.println("잘못된 입력입니다. 다시 입력하세요: ");
    	}

	    if(isDupStd(studentId)) {
	    	 System.out.println("이미 존재하는 학번입니다. 다시 입력해주세요: ");
	    		//  중복, 잘못된 입력 처리하기
	    	 sc.next();
	    	 studentId = sc.nextInt();
	    }
	    
    	System.out.print("이름: ");
	    String stdName = sc.next();
	    System.out.print("학년: ");
	    int grade = sc.nextInt();
	    // 입력값이 유효한지 확인하기 (1~4)
	    sc.nextLine();
	    System.out.print("학과: ");
	    String departmentName = sc.next();
	    // 입력값이 유효한지 확인하기 
//	    (학과가 이미 등록이 되어있는 건지 아닌지... 근데 이건 학과 부분 개발한거 가져오면 될듯?)
	    Department Dep = new Department(departmentName);
	    
        Student newStudent = new Student(studentId, stdName,  grade, Dep);
    	return newStudent;
    }
    
    // 이미 등록된 학생인 지 확인하는 메서드
    public boolean isDupStd(int studentId) {
    	if(students.size()==0) {
    		return false;
    	}
    	 for (int i = 0; i < students.size(); i++) {
    		 Student std= students.get(i);
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
    	students.stream().forEach((s)->System.out.println(s+"\n"));
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
    public void updateStudent() {
    	
    	System.out.println("=============\n수정할 학생 정보 입력");
        int oldStudentId = sc.nextInt();
        if(!isDupStd(oldStudentId)) { // 등록되지 않은 학생일 경우
        	System.out.println("등록되지 않은 학생입니다.");
        	return; // 재입력 받는 코드 작성 필요함
        }
        Student oldStudent = new Student(oldStudentId); // 학번이 일치하는 객체를 찾기 위해 임시로 객체를 생성함
        int idx = students.indexOf(oldStudent); // 학번이 일치하는 학생 객체를 찾아 인덱스 반환
        oldStudent = students.get(idx);
        
        // 수정된 학생정보 객체 생성
        System.out.print("새로운 학생 정보 입력");
        Student reviseStd = createStd();
        
//        // 수강신청 목록 유지 여부 입력받기
//        // (전과를 하는 경우 수강신청 목록이 의미없어지는 경우가 있어서.)
//        // (아예 예전 객체와 과를 비교해서 다른 과면 이게 출력되도록 할까???)
//        System.out.print("수강신청 정보를 유지합니까? (Y/N)");
//        char yn = sc.next().charAt(0);
//        if(yn == 'Y' | yn=='y') {
//        	// 기존 학생의 수강 정보를 가져와서(getLectureList) 수정된 학생 정보 객체에 이전하는 코드 추가 예정
//        }
        
        System.out.println("학생 삭제됨: "+students.remove(idx));
        students.add(reviseStd);
        System.out.println(oldStudent.getStdName() + "가 " + reviseStd.getStdName() + "으로 수정되었습니다.");
        return;


    }

    // 삭제
    public void deleteStudent() {
	   	 System.out.print("삭제할 학생 학번 입력 :");
	     int deleteStudentId = sc.nextInt();
 
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getStudentId()==deleteStudentId) {
                	students.remove(i);
                    System.out.println(deleteStudentId + "번 학생이 삭제 되었습니다.");
                    return;
                }
            }
            System.out.println(deleteStudentId + "와 일치하는 학번을 가진 학생 찾을 수 없습니다.");
        
        printStudent();
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
    	 return false;
    }

}
