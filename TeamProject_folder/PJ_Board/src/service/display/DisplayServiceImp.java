package service.display;

import java.util.Scanner;


public class DisplayServiceImp implements DisplayService {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void Display(Runnable... methods) {
        int input = 0;
        int currentPage = 0;
        final int pageSize = 5;
        int totalPages = (returnObjectSize() + pageSize - 1) / pageSize;
        final int EXIT = 0;

        do {

            print(currentPage, totalPages);
            printObject(currentPage * pageSize, pageSize);
            
            methods[0].run();
            input = sc.nextInt();

            if (input == 1 && currentPage > 0) {
                currentPage--;
            } else if (input == 2 && currentPage < totalPages - 1) {
                currentPage++;
            } else if (input == 3) { // 조회
                methods[1].run();
            }
        } while (input != EXIT);

    }

    private void print(int currentPage, int totalPages) {
        System.out.println("======= (페이지 " + (currentPage + 1) + " / " + totalPages
                + ") ==========");
    }
}
