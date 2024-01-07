package homework3;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountBook {
    private List<IncomeExpense> IncomeExpense = new ArrayList<IncomeExpense>(); // 수입지출 객체 관리 리스트
    
    
	public boolean insertIncomeExpense(IncomeExpense ie) {
		IncomeExpense.add(ie);
		return true;
	}
	
	public boolean checkIncomeExpense(IncomeExpense ie) {
		int index = IncomeExpense.indexOf(ie);
		System.out.println(index);
		if(index < 0) {
			return false;
		}
		
		
		return true;
	}
	
	public void updateIncomeExpense(IncomeExpense ie, IncomeExpense newie) {
		int index = IncomeExpense.indexOf(ie);
		IncomeExpense.remove(index);
		IncomeExpense.add(newie);
		
	}
	
	public void deleteIncomeExpense(IncomeExpense ie) {
		if(IncomeExpense.remove(ie)) {
			System.out.println("삭제완료");
			System.out.println(IncomeExpense);
		}else {
			System.out.println("등록되지 않은 단어입니다.");
		}
	}
	
	//확인용
	public void printAccountBook() {
		IncomeExpense.stream().forEach(s-> System.out.println(s));
	}
	
	
}
