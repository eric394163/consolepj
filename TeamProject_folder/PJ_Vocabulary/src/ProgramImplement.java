package homework;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
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
                game();
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
                String inputAddWord = sc.nextLine();
                while (myVocabulary.duplicateCheckWord(inputAddWord)) {
                    System.out.print("이미 등록된 단어 : ");
                    inputAddWord = sc.next();
                    sc.nextLine();
                }
                System.out.print(inputAddWord + "의 품사 :");
                String inputPartSpeech = sc.nextLine();
                while (!myVocabulary.checkPartOfSpeech(inputPartSpeech)) {
                    System.out.print("잘못된 품사 다시 입력 : ");
                    inputPartSpeech = sc.next();
                    sc.nextLine();
                }
                ArrayList<String> meanings = new ArrayList<>();
                System.out.println(inputAddWord + "의 뜻 : ( 'q' 입력시 뜻 입력 종료 )");
                readMean(meanings);
                myVocabulary.addWord(inputAddWord, inputPartSpeech, meanings);
                System.out.println("단어가 추가되었습니다.");

                break;

            case 2:
                // 단어 수정
                System.out.println("==================================");
                System.out.print("수정할 단어 : ");
                String inputUpdateWord = sc.next();

                System.out.println("==================================");
                System.out.println("1. 뜻 수정");
                System.out.println("2. 단어 수정");
                System.out.println("==================================");
                System.out.print("선택: ");
                int input = sc.nextInt();
                sc.nextLine();

                switch (input) {
                    case 1:
                        // 뜻 수정
                        ArrayList<String> newMeanings = new ArrayList<>();
                        System.out.print("새로운 뜻: (입력 끝나면 'q')");
                        readMean(newMeanings);
                        myVocabulary.updateWordMeaning(inputUpdateWord, newMeanings);
                        break;
                    case 2:
                        // 단어 수정
                        System.out.print("새로운 단어: ");
                        String newWord = sc.nextLine();
                        System.out.print(newWord + "의 품사 :");
                        String inputNewPartSpeech = sc.nextLine();
                        while (!myVocabulary.checkPartOfSpeech(inputNewPartSpeech)) {
                            System.out.print("잘못된 품사 다시 입력 : ");
                            inputNewPartSpeech = sc.next();
                            sc.nextLine();
                        }
                        myVocabulary.updateWordName(inputUpdateWord, newWord, inputNewPartSpeech);
                        break;
                }
                break;

            case 3:
                // 단어 삭제
                System.out.println("==================================");
                System.out.print("삭제할 단어: ");
                String inputDelete = sc.nextLine();
                myVocabulary.deleteWord(inputDelete);

                break;
            case 4:
                // 종료
                break;
            default:
                throw new InputMismatchException();
        }

    }

    private void readMean(ArrayList<String> meanings) {
        while (true) {
            String meaning = sc.next();
            sc.nextLine();
            if (meaning.equals("q")) {
                break;
            }
            if (myVocabulary.duplicateCheckMeaning(meaning)) {
                System.out.println("이미 등록된 뜻 다시 입력");
                continue;
            }
            if (meanings.contains(meaning)) {
                System.out.println("이미 입력한 뜻 다시 입력");
                continue;
            }
            meanings.add(meaning);
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
        System.out.println("3. 단어 조회수 순위 ");
        System.out.println("4. 이전 ");
        System.out.println("==================================");
        System.out.print("메뉴 선택  :");

    }

    private void runVocabulary(int inputMenu) {

        int wordSize = myVocabulary.getWordListSize();

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
                final int pageSize = 5; // 한 페이지에 들어갈 단어 수
                int totalPages = (wordSize + pageSize - 1) / pageSize; // 총 페이지 수 계산 (단어장 수 + 페이지 크키 -1)/페이지크기

                do {
                    System.out.println("======= 단어장 (페이지 " + (currentPage + 1) + " / " + totalPages
                            + ") ==========");

                    myVocabulary.printVocabulary(currentPage * pageSize, pageSize);

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
                // 많이 조회한 단어 조회
                searchRank();
                break;
            case 4:
                // 종료
                break;
            default:
                throw new InputMismatchException();
        }

    }

    // 게임
    // =======================================================================================================================================
    private void game() {
        Random random = new Random();
        int wordListSize = myVocabulary.getWordListSize();

        int rndNum = random.nextInt(wordListSize);
        Words randomWord = myVocabulary.getRndWord(rndNum);
        System.out.println("======== 미니게임 ========");
        System.out.print(randomWord.getWord() + "의 뜻 : ");
        sc.nextLine();
        String userInput = sc.nextLine();

        if (randomWord.getMeaning().contains(userInput)) {
            System.out.println("정답");
        } else {
            System.out.println("오답 // 정답 : " + randomWord.getMeaning());
        }

    }

    private void searchRank() {
        myVocabulary.sortSearchedCnt(); // 많이 검색한 순서 대로 단어 정렬하기
        myVocabulary.printWords();
    }

    // 조회

}
