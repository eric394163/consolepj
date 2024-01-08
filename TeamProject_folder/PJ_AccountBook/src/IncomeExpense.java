package homework3;


public class IncomeExpense {
    boolean incomeOrExpense; // 수입이면 true 지출이면 false
    long totalAmount; // 총 금액
    long transactionAmount; // 거래 금액
    String incomeExpenseDetails; // 내용
    String category; // 수입지출 카테고리 (수입 : 용돈, 월급, ...) (지출: 의료비, 교통비, 식비, ...) => enum으로

    String date; // 거래 날짜 

    String dateMonth; // 월별 검색을 위해 따로 빼두기 

}
