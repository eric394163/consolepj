package PJ_AccountBook;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AccountBook{
	
	private List<IncomeExpense> incomeExpense;

    public AccountBook() {
        this.incomeExpense = new ArrayList<>();
    }
    
    
    public AccountBook(List<IncomeExpense> list) {
		if(list == null) {
			list = new ArrayList<IncomeExpense>();
		}
		this.incomeExpense = list;
	}
    

    // 가계부 리스트 길이 반환 메서드
    // =======================================================================================================================================
    public int getAccountBookSize() {
        return incomeExpense.size();
    }

    // 수입지출 추가 메서드
    // =======================================================================================================================================
    public void addIncomeOrExpense(IncomeExpense incomeExpense) {
        this.incomeExpense.add(incomeExpense);
    }

    // 수입지출 추가 확인 메서드
    public void printAllIncomeExpenses() {
        for (IncomeExpense item : incomeExpense) {
            System.out.println(item.toString());
        }
    }

    // 수입지출 출력 메서드
    // =======================================================================================================================================
    public void printIncomeExpense(int startIndex, int pageSize) {
        if (incomeExpense.isEmpty()) {
            System.out.println("빈 가계부");
            return;
        }

        int endIndex = Math.min(startIndex + pageSize, incomeExpense.size());
        for (int i = startIndex; i < endIndex; i++) {
            IncomeExpense IE = incomeExpense.get(i);
            System.out.println(
                    (i + 1) + "." + "||" + IE.getDate() + "||" + IE.getAmount() + "||" + IE.getCategory() + "||"
                            + IE.getIncomeExpenseDetails());
        }
    }

    // 가계부 리스트 인덱스 가져오기
    // =======================================================================================================================================
    public IncomeExpense getIncomeExpense(int index) {
        if (index >= 0 && index < incomeExpense.size()) {
            return incomeExpense.get(index);
        }
        return null;
    }

    public int getIncomeExpenseIndex(int index) {
        if (index >= 0 && index < incomeExpense.size()) {
            return index;
        }
        return -1; // Return -1 or any other invalid value to indicate the index is out of bounds
    }

    // 가계부 수정 메서드
    // =======================================================================================================================================
    public void updateIncomeExpense(int index, IncomeExpense newIncomeExpense) {
        if (index >= 0 && index < incomeExpense.size()) {
            incomeExpense.set(index, newIncomeExpense);
        } else {
            System.out.println("유효하지 않은 인덱스");
        }
    }

    // 가계부 삭제 메서드
    public void deleteIncomeExpense(int index) {
        if (index >= 0 && index < incomeExpense.size()) {
            incomeExpense.remove(index);
            System.out.println("가계부 항목이 삭제되었습니다.");
        } else {
            System.out.println("유효하지 않은 인덱스");
        }
    }
}
