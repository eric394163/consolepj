package Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Word {
	
	private String word, mean;
	//단어 뜻

	public void addMean(String mean) {
		this.mean = mean;
}
}