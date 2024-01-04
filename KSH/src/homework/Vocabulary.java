package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Vocabulary {

    static Scanner sc = new Scanner(System.in);
    private ArrayList<String> words;
    private HashMap<Integer, ArrayList<String>> meanings;

    public Vocabulary() {
        words = new ArrayList<>();
        meanings = new HashMap<>();
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public HashMap<Integer, ArrayList<String>> getMeanings() {
        return meanings;
    }

    public int getTotalWordSize() {
        return words.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((words == null) ? 0 : words.hashCode());
        result = prime * result + ((meanings == null) ? 0 : meanings.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vocabulary other = (Vocabulary) obj;
        if (words == null) {
            if (other.words != null)
                return false;
        } else if (!words.equals(other.words))
            return false;
        if (meanings == null) {
            if (other.meanings != null)
                return false;
        } else if (!meanings.equals(other.meanings))
            return false;
        return true;
    }

    // 단어 추가 메서드
    // ===========================================================================================

    public void addWord(String word) {

        while (words.contains(word)) {
            sc.nextLine();
            System.out.print("다른 단어 입력하세요 :");

            word = sc.nextLine();
        }

        System.out.println(word + "'의 뜻을 입력. (입력이 끝나면 'exit' 입력)");

        ArrayList<String> meaningsList = new ArrayList<>();
        String meaning;

        while (true) {
            meaning = sc.nextLine();
            if (meaning.equals("exit")) {
                break;
            }
            meaningsList.add(meaning);
        }

        words.add(word);
        meanings.put(words.size() - 1, meaningsList);
        System.out.println(word + "추가 완료.");

    }
    // =================================================================================================================

    // 단어장 출력 메서드
    // =================================================================================================================

    public void printWords(int startIndex, int pageSize) {
        if (words.isEmpty()) {
            System.out.println("빈 단어장");
            return;
        }

        for (int i = startIndex; i < Math.min(startIndex + pageSize, words.size()); i++) {
            String word = words.get(i);
            ArrayList<String> meaningsList = meanings.get(i);
            System.out.println((i + 1) + ". " + word + ": " + meaningsList);
        }
    }

    // 단어 검색 메서드
    // ===========================================================================================================================
    public void searchWord(String word) {
        int wordIndex = words.indexOf(word);

        if (wordIndex == -1) {
            System.out.println("빈 단어장");
        } else {
            ArrayList<String> meaningsList = meanings.get(wordIndex);
            System.out.println(word + "의 뜻 :");
            for (String meaning : meaningsList) {
                System.out.println(meaning);
            }
        }
    }
    // ===================================================================================================================

    // 단어 수정 메서드
    // ===================================================================================================================

    public void updateWord(String oldWord, String newWord) {
        int index = words.indexOf(oldWord);
        words.set(index, newWord);
        System.out.println(oldWord + " 단어가 " + newWord + "로 업데이트 됨");

    }

    public void updateMeanings(String word, ArrayList<String> newMeanings) {
        int index = words.indexOf(word);

        meanings.put(index, newMeanings);
        System.out.println(word + "의 뜻이 업데이트 됨");
    }

    // ===================================================================================================================

    // 단어 삭제 메서드
    // ===================================================================================================================
    public void deleteWord(String word) {
        int index = words.indexOf(word);
        if (index == -1) {
            System.out.println(" 단어 없음");
            return;
        }

        words.remove(index);
        meanings.remove(index);

        // 인덱스 수정
        for (int i = index; i < words.size(); i++) {
            ArrayList<String> temp = meanings.get(i + 1);
            meanings.put(i, temp);
        }
        // 마지막 인덱스 삭제
        meanings.remove(words.size());

        System.out.println(word + " 단어 삭제 완료");
    }
    // ===================================================================================================================

}
