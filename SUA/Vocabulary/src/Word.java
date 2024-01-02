

import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

 @EqualsAndHashCode
 @Getter
 @Setter
public class Word {
	private String word;
	private char type;
	private Set<String> meaning = new HashSet<String>();
	private int searchNum=0;
	
	
	
	public Word(String word, char type, String meaning) {
		this.word = word;
		this.type = type;
		this.meaning.add(meaning);
		searchNum=0;
		
	}
	
	public Word(String word, char type, String meaning, int searchNum) {
		this.word = word;
		this.type = type;
		this.meaning.add(meaning);
		this.searchNum=searchNum;
		
	}
	
	
	public Word(String word, char type) {
		this.word = word;
		this.type = type;
	}


	public Set<String> getMeaning() {
		return meaning;
	}


	public void setMeaning(String meaning) {
		this.meaning.add(meaning);
	}
	
	public void printInfo() {
		System.out.println(word+" ["+type+"] | 단어 뜻: "+meaning); // 대괄호 형식으로 나오는데 예쁘게 출력할 수 있나?

	}
	public void searchWord() {
		System.out.println(word+" ["+type+"]");
		System.out.println("단어 뜻: "+meaning);
		System.out.println("---------------");
		System.out.println("단어 조회 횟수: "+ ++searchNum);
	}
	public void addMean(String mean) {
		meaning.add(mean);
	}
	public void removeMean(String mean) {
		meaning.remove(mean);
	}
}
