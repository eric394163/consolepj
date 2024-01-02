package day15.homework;

public class HomeworkEx1 {

	/* 영어 단어장을 관리하는 프로그램을 작성하세요.
	 * 기한: ~ 24.01.05
	 * git에 업로드 후 단톡방 공유
	 * - 한 단어에 뜻이 여러개 있을 수 있음
	 * - 단어, 품사(명사, 동사 등..), 뜻을 관리
	 * - 단어 추가
	 * - 단어 수정
	 * - 단어 삭제
	 * - 뜻 추가
	 * - 뜻 수정
	 * - 뜻 삭제
	 * - 단어 조회
	 * 
	 * - 기타 추가 기능을 구현해도 됨
	 * - 등록된 단어장에서 랜덤으로 문제가 나오고 맞추는 기능
	 * - 오답노트를 관리하는 기능
	 * - 많이 조회한 단어를 확인하는 기능
	 */
	/* Program 인터페이스 생성하여 활용
	 * Program 인터페이스를 구현한 구현 클래스 WordProgram을 생성하여 활용
	 * 단어, 뜻, 품사 정보는 Word 클래스를 생성하여 활용
	 */
	public static void main(String[] args) {
		WordProgram wp = new WordProgram();
		wp.run();

	}

}
