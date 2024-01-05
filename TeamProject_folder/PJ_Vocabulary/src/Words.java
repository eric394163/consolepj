package homework;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Words {
    String word;
    String partSpeech;
    private ArrayList<String> meaning;
    int searchedCnt;

    public Words(String word, String partSpeech, ArrayList<String> meaning) {
        this.word = word;
        this.partSpeech = partSpeech;
        this.meaning = meaning;
    }

    public int searchedCount() {
        searchedCnt++;
        return searchedCnt;
    }

}
