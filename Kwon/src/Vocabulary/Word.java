package day15.homework;

import java.util.ArrayList;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Word {
	// 단어, 품사, 뜻(리스트)
	@NonNull
	private String word, PoS, meaning;
	private ArrayList<String> means = new ArrayList<String>();
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return this.word.equals(other.word);
	}
	@Override
	public int hashCode() {
		return Objects.hash(word, PoS);
	}
	
	//뜻을 여러 개 저장할 수 있게 하기 위해 means 리스트에 뜻을 추가하는 메서드
	public void addMean(String meaning) {
		means.add(meaning);
		System.out.println("뜻 추가--");
	}
	
	//means 리스트에 뜻을 삭제하는 메서드
	public void delMean(String meaning) {
		means.remove(meaning);
		System.out.println("뜻 삭제--");
	}
	
	//means 리스트의 길이를 반환하는 메서드
	public int meansLen() {
		return this.means.size();
	}


}
