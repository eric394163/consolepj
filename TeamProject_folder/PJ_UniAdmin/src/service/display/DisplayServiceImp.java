package service.display;

import java.util.Scanner;

import model.ManageUni;

public class DisplayServiceImp implements DisplayService {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void Display(ManageUni manageUni, int selectModel, Runnable... methods) {
        int input = 0;
        int currentPage = 0;
        final int pageSize = 5;
        int totalPages = 0;
        final int EXIT = 0;

        do {

            if (selectModel == 1) { // 강좌
                // manageUni.printDepartment(currentPage * pageSize, pageSize);
            } else if (selectModel == 2) { // 강의
                totalPages = (manageUni.returnLectSize() + pageSize - 1) / pageSize;
                print(currentPage, totalPages);
            } else if (selectModel == 3) { // 과
                totalPages = (manageUni.returnDeptSize() + pageSize - 1) / pageSize;
                print(currentPage, totalPages);
                manageUni.printDepartment(currentPage * pageSize, pageSize);
            } else if (selectModel == 4) { // 교수
                totalPages = (manageUni.returnProfSize() + pageSize - 1) / pageSize;
                print(currentPage, totalPages);
                manageUni.printProfessor(currentPage * pageSize, pageSize);
            } else if (selectModel == 5) { // 학생
                totalPages = (manageUni.returnStdSize() + pageSize - 1) / pageSize;
                print(currentPage, totalPages);
                manageUni.printStudent(currentPage * pageSize, pageSize);
            } else if (selectModel == 6) { // 수강
                // manageUni.printDepartment(currentPage * pageSize, pageSize);
            } else if (selectModel == 7) { // 조회
                // manageUni.printDepartment(currentPage * pageSize, pageSize);
            }

            methods[0].run();
            input = sc.nextInt();

            if (input == 1 && currentPage > 0) {
                currentPage--;
            } else if (input == 2 && currentPage < totalPages - 1) {
                currentPage++;
            } else if (input == 3) { // 수정, 삭제
                methods[1].run();
            }
        } while (input != EXIT);

    }

    private void print(int currentPage, int totalPages) {
        System.out.println("======= (페이지 " + (currentPage + 1) + " / " + totalPages
                + ") ==========");
    }
}
