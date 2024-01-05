package ledger;

public class LedgerMain {

	/* 가계부 프로그램
	 *  ~ 2024.01.12. 팀 과제
	 *  
	 *  1. 가계부 작성
	 *  	- +로 입력 시 수입 / -로 입력 시 지출
	 *  		- 날짜, 내역 입력
	 *  
	 *  2. 가계부 수정
	 *  	- 수입, 지출, 날짜, 내역 수정
	 *  
	 *  3. 가계부 삭제
	 *  	- 수입, 지출, 날짜, 내역 삭제
	 *  
	 *  -------------------- 추가 기능 ---------------------
	 *  
	 *  4. 가계부 검색
	 *  	- 월별 검색
	 *  		- 해당 월의 날짜 검색 시 수입/지출 내역 모두 보이게끔
	 *  	- 내역(카테고리)별로 검색
	 *  		- 특정 내역 키워드 입력 시 수입/지출 내역 모두 보이게끔
	 *  
	 *  5. 총수입/지출 조회
	 *  	- 월별 검색
	 *  		- 해당 달의 총수입, 총지출
	 *  	- 내역별로 검색
	 *  		- 해당 내역의 총수입, 총지출
	 * 
	 */
	public static void main(String[] args) {
		LedgerProgram lp = new LedgerProgram();
		lp.run();
	}

}
