package PJ_AccountBook;

import java.io.Serializable;

import lombok.Data;

@Data

public class IncomeExpense implements Serializable{

	private static final long serialVersionUID = 5993579677313832508L;
	
	boolean incomeOrExpense; // 수입이면 true, 지출이면 false
    long amount; // 거래 금액
    String incomeExpenseDetails; // 내용
    String category; // 카테고리
    String date; // 거래 날짜
    int dateMonth; // 월별 검색을 위한 필드
    int dateYear;
    int dateDay;

    public IncomeExpense(boolean incomeOrExpense, long amount, String incomeExpenseDetails, String category,
            String date, int dateMonth, int dateYear, int dateDay) {
        this.incomeOrExpense = incomeOrExpense;
        this.amount = amount;
        this.incomeExpenseDetails = incomeExpenseDetails;
        this.category = category;
        this.date = date;
        this.dateMonth = dateMonth;
        this.dateYear = dateYear;
        this.dateDay = dateDay;
    }

	@Override
	public String toString() {
		return " =========================\n[수입/지출] : " + incomeOrExpense + "\n 금액 : " + amount + "\n내역 : "
				+ incomeExpenseDetails + "분류 : " + category + "\n날짜 : " + date;
	}

}
