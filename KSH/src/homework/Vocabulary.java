package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vocabulary {
    private List<Words> wordList;

    public Vocabulary(List<Words> wordList) {
        this.wordList = wordList;
    }

    private String[] partOfSpeechList = { "형", "명", "부", "전", "관" };

    public Vocabulary() {
        wordList = new ArrayList<>();
    }

    public int getWordListSize() {

        return wordList.size();
    }

    public Words getRndWord(int rndNum) {

        return wordList.get(rndNum);

    }

    // 단어 중복 체크
    public boolean duplicateCheckWord(String word) {
        for (Words w : wordList) {
            if (w.getWord().equals(word)) {
                System.out.println("중복된 단어");
                return true;
            }
        }
        return false;
    }

    // 뜻 중복 체크
    public boolean duplicateCheckMeaning(String meaning) {
        for (Words word : wordList) {
            if (word.getMeaning().contains(meaning)) {
                return true;
            }
        }
        return false;
    }

    // 품사 체크
    public boolean checkPartOfSpeech(String partOfSpeech) {
        for (String validPart : partOfSpeechList) {
            if (validPart.equals(partOfSpeech)) {
                return true;
            }
        }
        return false;
    }

    // 단어 추가
    public void addWord(String word, String partOfSpeech, ArrayList<String> meanings) {
        wordList.add(new Words(word, partOfSpeech, meanings));
    }

    // 단어 검색
    public Words searchWord(String word) {
        for (Words w : wordList) {
            if (w.getWord().equals(word)) {
                w.searchedCount();
                System.out.println(
                        w.getWord() + "(" + w.getPartSpeech() + ")" + " : " + w.getMeaning() + "  조회수 : ("
                                + w.searchedCnt
                                + ")");
            }
        }
        return null;
    }

    // 뜻 수정
    public void updateWordMeaning(String word, ArrayList<String> newMeanings) {
        for (Words w : wordList) {
            if (w.getWord().equals(word)) {
                w.setMeaning(newMeanings);
                return;
            }
        }
    }

    // 단어 수정
    public void updateWordName(String oldWord, String newWord, String newPartSpeech) {
        for (Words w : wordList) {
            if (w.getWord().equals(oldWord)) {
                w.setWord(newWord);
                w.setPartSpeech(newPartSpeech);
                return;
            }
        }
    }

    // 단어 삭제
    public void deleteWord(String word) {
        Iterator<Words> iterator = wordList.iterator();
        while (iterator.hasNext()) {
            Words currentWord = iterator.next();
            if (currentWord.getWord().equals(word)) {
                iterator.remove();
                System.out.println(word + " 단어가 삭제되었습니다.");
                return;
            }
        }
        System.out.println(word + " 단어를 찾을 수 없습니다.");
    }

    // 단어장 출력
    public void printVocabulary(int startIndex, int pageSize) {
        if (wordList.isEmpty()) {
            System.out.println("빈 단어장");
            return;
        }

        int endIndex = Math.min(startIndex + pageSize, wordList.size());
        for (int i = startIndex; i < endIndex; i++) {
            Words word = wordList.get(i);
            System.out.println(
                    (i + 1) + ". " + word.getWord() + " (" + word.getPartSpeech() + ") : " + word.getMeaning());
        }
    }

    public void printWords() {
        for (int i = 0; i < getWordListSize(); i++) {
            Words word = wordList.get(i);
            System.out.println((i + 1) + ". " + word.getWord() + " (" + word.getPartSpeech() + ") : "
                    + word.getMeaning() + "조회수 : " + word.searchedCnt);
        }
    }

    // 조회수에 맞게 정렬
    public void sortSearchedCnt() {
        wordList.sort((s1, s2) -> {
            if (s1.searchedCount() != s2.searchedCount()) {
                return s2.searchedCount() - s1.searchedCount();
            }
            return 0;
        });
    }

    public Words words() {
        return wordList.get(getWordListSize());
    }

    public List<Words> getWordList() {
        return wordList;
    }

    public String[] getPartOfSpeechList() {
        return partOfSpeechList;
    }

    public Words getWord(int i) {
        return words();
    }
}
