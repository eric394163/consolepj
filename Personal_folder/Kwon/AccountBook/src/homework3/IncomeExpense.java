package homework3;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class IncomeExpense {
    boolean incomeOrExpense; // 수입이면 true 지출이면 false
    long totalAmount; // 총 금액
    long transactionAmount; // 거래 금액
    String incomeExpenseDetails; // 내용
    String category; // 수입지출 카테고리 (수입 : 용돈, 월급, ...) (지출: 의료비, 교통비, 식비, ...) => enum으로
    enum category_enum {
    	Allowance, //용돈
    	Salary,	   //월급
    	Food,		//식비
    	Transportation, //교통비
    	Hobby,			//취미
    	Clothes,		//의류
    	Health			//의료/건강
    }

    String date; // 거래 날짜 

    String dateMonth; // 월별 검색을 위해 따로 빼두기 

    
    

	public IncomeExpense(boolean incomeOrExpense, long transactionAmount, String incomeExpenseDetails, String category, String date) {
		this.incomeOrExpense = incomeOrExpense;
		this.transactionAmount = transactionAmount;
		this.incomeExpenseDetails = incomeExpenseDetails;
		this.category = category;
		this.date = date;
		
		totalAmount += transactionAmount;
		
		switch(category) {
		case "0":
			category_enum allowance = category_enum.Allowance;
			break;
		case "1":
			category_enum salary = category_enum.Salary;
			break;
		case "2":
			category_enum food = category_enum.Food;
			break;
		case "3":
			category_enum transportation = category_enum.Transportation;
			break;
		case "4":
			category_enum hobby = category_enum.Hobby;
			break;
		case "5":
			category_enum clothes = category_enum.Clothes;
			break;
		case "6":
			category_enum health = category_enum.Health;
		default:
			System.out.println("잘못된 카테고리입니다.");
			return;
		}
		
		//월 따로 빼두기
		//
		
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncomeExpense other = (IncomeExpense) obj;
		return this.category.equals(other.category) && this.date.equals(other.date)
				&& transactionAmount == other.transactionAmount;
	}




	@Override
	public int hashCode() {
		return Objects.hash(category, date, transactionAmount);
	}




	
}
