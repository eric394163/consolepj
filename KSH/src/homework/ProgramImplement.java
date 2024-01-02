package homework;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramImplement implements MainProgram {

    private final int EXIT = 4;
    private Scanner sc = new Scanner(System.in);
    private Vocabulary myVocabulary = new Vocabulary();

    // 메인
    // ================================================================================================================
    @Override
    public void run() {
        int inputMainMenu = 0;
        // 반복
        do {
            // 메뉴 출력
            printMainMenu();
            try {
                // 메뉴 선택
                inputMainMenu = sc.nextInt();
                // 메뉼 실행
                runMainMenu(inputMainMenu);
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (inputMainMenu != EXIT);
    }

    private void runMainMenu(int inputMainMenu) {
        switch (inputMainMenu) {
            case 1:
                // 단어 추가/수정/삭제
                VocaAddUpdateDelete();

                break;
            case 2:
                // 단어장
                vocabulary();

                break;
            case 3:
                // 미니 게임
                break;
            case 4:
                System.out.println("프로그램 종료.");
                break;
            default:
                throw new InputMismatchException();
        }
    }

    private void printMainMenu() {
        System.out.println("============= 단어장 =============");
        System.out.println("1. 단어 추가/수정/삭제 ");
        System.out.println("2. 단어장 ");
        System.out.println("3. 미니 게임 ");
        System.out.println("4. 프로그램 종료 ");
        System.out.println("==================================");
        System.out.print("메뉴 선택  :");
    }

    // 메인
    // ================================================================================================================

    // 단어 추가 수정 삭제
    // ================================================================================================================

    private void VocaAddUpdateDelete() {

        int inputMenu = 0;

        do {
            printVocaAddUpdateDelete();
            try {
                inputMenu = sc.nextInt();
                sc.nextLine();
                runVocaAddUpdateDelete(inputMenu);
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (inputMenu != EXIT);
    }

    private void printVocaAddUpdateDelete() {
        System.out.println("======= 단어 추가/수정/삭제 =======");
        System.out.println("1. 추가 ");
        System.out.println("2. 수정 ");
        System.out.println("3. 삭제 ");
        System.out.println("4. 이전 ");
        System.out.println("==================================");
        System.out.print("메뉴 선택  :");
    }

    private void runVocaAddUpdateDelete(int inputMenu) {

        switch (inputMenu) {
            case 1:
                // 단어 추가
                System.out.println("==================================");
                System.out.print("추가할 단어 : ");
                String inputAddWord = sc.next();
                sc.nextLine();
                myVocabulary.addWord(inputAddWord);
                break;

            case 2:
                // 단어 수정
                System.out.println("==================================");
                System.out.print("수정할 단어 : ");
                String inputUpdateWord = sc.next();
                if (!myVocabulary.getWords().contains(inputUpdateWord)) {
                    System.out.println(inputUpdateWord + "단어는 단어장에 없음");
                    break;
                }

                System.out.println("==================================");
                System.out.println("1. 뜻 수정");
                System.out.println("2. 단어 수정");
                System.out.println("==================================");
                System.out.print("선택: ");
                int input = sc.nextInt();
                sc.nextLine();

                if (input == 1) {
                    // 뜻 수정
                    System.out.println(inputUpdateWord + "의 새로운 뜻 입력. (입력이 끝나면 'exit' 입력)");
                    ArrayList<String> newMeanings = new ArrayList<>();
                    String meaning;
                    while (true) {
                        meaning = sc.nextLine();
                        if (meaning.equals("exit")) {
                            break;
                        }
                        newMeanings.add(meaning);
                    }
                    myVocabulary.updateMeanings(inputUpdateWord, newMeanings);
                } else if (input == 2) {
                    // 단어 수정
                    System.out.print("새로운 단어: ");
                    String newWord = sc.next();
                    sc.nextLine();
                    myVocabulary.updateWord(inputUpdateWord, newWord);
                }
                break;

            case 3:
                // 단어 삭제
                System.out.println("==================================");
                System.out.print("삭제할 단어 : ");
                String inputDeleteWord = sc.next();
                sc.nextLine();
                myVocabulary.deleteWord(inputDeleteWord);

                break;
            case 4:
                // 종료
                break;
            default:
                throw new InputMismatchException();
        }

    }

    // 단어장
    // =======================================================================================================================================

    private void vocabulary() {

        int inputMenu = 0;

        do {
            printVocabularyMenu();
            try {
                inputMenu = sc.nextInt();
                sc.nextLine();
                runVocabulary(inputMenu);
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴입니다.");
                sc.nextLine();
            }
        } while (inputMenu != 3);
    }

    private void printVocabularyMenu() {
        System.out.println("============= 단어장 =============");
        System.out.println("1. 단어 검색 ");
        System.out.println("2. 단어장 ");
        System.out.println("3. 이전 ");
        System.out.println("==================================");
        System.out.print("메뉴 선택  :");

    }

    private void runVocabulary(int inputMenu) {

        int wordSize = myVocabulary.getTotalWordSize();

        switch (inputMenu) {
            case 1:
                // 단어 검색
                System.out.print("검색할 단어 : ");
                String inputWord = sc.next();
                sc.nextLine();
                myVocabulary.searchWord(inputWord);
                break;
            case 2:
                // 단어장
                if (wordSize == 0) {
                    System.out.println("단어 없음");
                    break;
                }

                int input = 0;
                int currentPage = 0;
                final int pageSize = 20; // 한 페이지에 들어갈 단어 수
                int totalPages = (wordSize + pageSize - 1) / pageSize; // 총 페이지 수 계산 (단어장 수 + 페이지 크키 -1)/페이지크기

                do {
                    System.out.println("======= 단어장 (페이지 " + (currentPage + 1) + " / " + totalPages
                            + ") ==========");
                    myVocabulary.printWords(currentPage * pageSize, pageSize);

                    System.out.println("=======================================");
                    System.out.println("[ 이전 : 1 ]  [ 다음 : 2 ] [ 종료 : 3 ]");
                    System.out.println("=======================================");
                    System.out.print("입력 :");
                    input = sc.nextInt();

                    if (input == 1 && currentPage > 0) {
                        currentPage--;
                    } else if (input == 2 && currentPage < totalPages - 1) {
                        currentPage++;
                    }
                } while (input != 3);
                break;

            case 3:
                // 종료
                break;
            default:
                throw new InputMismatchException();
        }

    }

}
