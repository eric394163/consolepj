package homework3;

import lombok.Data;

@Data

public class IncomeExpense {
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

}
