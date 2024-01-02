package day15.homework;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/* 영어 단어장을 관리하는 프로그램을 작성하세요.
 * - 한 단어에 뜻이 여러개 있을 수 있음
 * - 단어, 품사(명사, 동사 등..), 뜻을 관리
 * - 단어 추가
 * - 단어 수정
 * - 단어 삭제
 * - 뜻 추가
 * - 뜻 수정
 * - 뜻 삭제
 * - 단어 조회
 * */
public class WordProgram implements Program {
	private Scanner scan = new Scanner(System.in);
	private final int EXIT = 8;
	private List<Word> list = new ArrayList<Word>();
	@Override
	public void run() {
		int menu = 0;
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				
				//메뉴 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != EXIT);
	}

	@Override
	public void printMenu() {
		System.out.println("=======메뉴=======");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 뜻 추가");
		System.out.println("5. 뜻 수정");
		System.out.println("6. 뜻 삭제");
		System.out.println("7. 단어 조회");
		System.out.println("8. 프로그램 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: //단어 추가
			insertWord();
			break;
		case 2: //단어 수정
			updateWord();
			break;
		case 3: //단어 삭제
			deleteWord();
			break;
		case 4: //뜻 추가
			insertMeaning();
			break;
		case 5: //뜻 수정
			updateMeaning();
			break;
		case 6: //뜻 삭제
			deleteMeaning();
			break;
		case 7: //단어 조회
			selectWord();
			break;
		case 8:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void selectWord() {
		System.out.println("=====단어 조회=====");
		//조회할 단어 입력
		System.out.print("조회할 단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		
		//조회할 단어가 등록되어 있는지 확인하기 위한 인스턴스 w 생성
		Word w = new Word(word, "", "");
		//조회할 단어의 인덱스값을 받아와서
		int index = list.indexOf(w);
		//없으면(인덱스 값이 -1이면) 등록되지 않은 값이라고 출력 후 종료
		if(index == -1) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		
		//현재 w에는 단어 값 밖에 없으므로
		w = list.get(index); //기존 단어 정보 저장
		
		//조회한 단어의 품사와 뜻 출력
		System.out.println("품사 : " + w.getPoS());
		System.out.print("뜻 : ");
		//i는 0부터 means 리스트의 길이보다 작을 때 까지 반복
		//means 리스트의 길이를 반환하는 메서드 실행
		for(int i = 0; i < w.meansLen(); i++) {
			//means리스트의 i번지에 해당하는 값 가져옴
			System.out.print(w.getMeans().get(i));
			
			//마지막 값 뒤에는 ,를 출력하지 않기 위해
			//i가 mean리스트의 길이 - 1 한 값보다 작을 때만
			if(i < w.meansLen()-1) {
				//, 출력
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	public void deleteMeaning() {
		System.out.println("======뜻 삭제======");
		//뜻 삭제할 단어 입력
		System.out.print("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		
		//뜻을 삭제할 단어가 등록되어 있는지 확인하기 위한 인스턴스 w 생성
		Word w = new Word(word, "", "");
		//뜻을 삭제할 단어의 인덱스값을 받아와서
		int index = list.indexOf(w);
		//없으면(인덱스 값이 -1이면) 등록되지 않은 값이라고 출력 후 종료
		if(index == -1) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		
		//현재 w에는 단어 값 밖에 없으므로
		w = list.get(index); //기존 단어 정보 저장
		
		//삭제할 뜻 입력
		System.out.print("삭제할 뜻 : ");
		String meaning = scan.nextLine();
		
		//w의 뜻 리스트 means에 삭제할 뜻 meaning이 포함되어있지 않으면
		if(!w.getMeans().contains(meaning)) {
			//존재하지 않는 뜻 이라고 출력 후 종료
			System.out.println("존재하지 않는 뜻 입니다.");
			return;
		}
		//포함되어 있다면
		//w의 delMean 메서드 실행
		w.delMean(meaning);
		System.out.println("뜻 삭제가 완료되었습니다.");
		//확인용 코드
		System.out.println(list);
	}

	public void updateMeaning() {
		System.out.println("======뜻 수정======");
		//뜻 수정할 단어 입력
		System.out.print("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();

		//뜻을 수정할 단어가 등록되어 있는지 확인하기 위한 인스턴스 w 생성
		Word w = new Word(word, "", "");
		//뜻을 수정할 단어의 인덱스값을 받아와서
		int index = list.indexOf(w);
		//없으면(인덱스 값이 -1이면) 등록되지 않은 값이라고 출력 후 종료
		if(index == -1) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		
		//현재 w에는 단어 값 밖에 없으므로
		w = list.get(index); //기존 단어 정보 저장
		
		//수정할 뜻 입력
		System.out.print("수정할 뜻 : ");
		String meaning = scan.nextLine();
		
		//수정할 단어 인스턴스 생성
		//품사는 입력받지 않았으므로 기존 단어 정보에 저장되어있는 품사 가져옴
		Word newW = new Word(word, w.getPoS(), meaning);
		
		//원래 있던 단어 삭제 후
		list.remove(index);
		//수정할 단어 인스턴스 값 추가
		list.add(newW);
		//뜻을 여러 개 저장할 수 있게 하기 위해 따로 리스트에 추가
		newW.addMean(meaning);
		
		System.out.println("단어의 뜻이 수정되었습니다.");
		//확인용 코드
		System.out.println(list);
	}

	public void insertMeaning() {
		System.out.println("======뜻 추가======");
		
		//뜻 추가할 단어 입력
		System.out.print("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		
		//뜻을 추가할 단어가 등록되어 있는지 확인하기 위한 인스턴스 w 생성
		Word w = new Word(word, "", "");
		
		//삭제할 단어의 인덱스값을 받아와서
		int index = list.indexOf(w);
		//없으면(인덱스 값이 -1이면) 등록되지 않은 값이라고 출력 후 종료
		if(index == -1) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		
		//현재 w에는 단어 값 밖에 없으므로
		w = list.get(index); //기존 단어 정보 저장
		
		//추가할 뜻 입력
		System.out.print("추가할 뜻 : ");
		String meaning = scan.nextLine();
		//뜻을 여러 개 저장할 수 있게 하기 위해 따로 리스트에 추가
		w.addMean(meaning);
		
		System.out.println("뜻 추가가 완료되었습니다.");
		//확인용 코드
		System.out.println(list);
	}

	public void deleteWord() {
		System.out.println("=====단어 삭제=====");
		//삭제할 단어 입력
		System.out.print("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();

		//삭제할 단어가 등록되어 있는지 확인하기 위한 인스턴스 w 생성
		Word w = new Word(word, "", "");
		
		//삭제 요청 후 삭제되면 삭제됐다고 알림, 삭제 안되면 안됐다고 알림
		if(list.remove(w)) {
			System.out.println("단어 삭제가 완료되었습니다.");
			//확인용 코드
			System.out.println(list);
		}else {
			System.out.println("등록되지 않은 단어입니다.");
		}
	}

	public void updateWord() {
		System.out.println("=====단어 수정=====");
		System.out.print("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();

		//수정할 단어가 등록되어 있는지 확인하기 위한 인스턴스 w 생성
		Word w = new Word(word, "", "");
		
		//수정할 단어의 인덱스값을 받아와서
		int index = list.indexOf(w);
		//없으면(인덱스 값이 -1이면) 등록되지 않은 값이라고 출력 후 종료
		if(index == -1) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
				
		//수정할 단어, 품사, 뜻을 입력
		System.out.print("수정할 단어 : ");
		word = scan.nextLine();
		System.out.print("수정할 품사 : ");
		String PoS = scan.next();
		System.out.print("수정할 뜻 : ");
		scan.nextLine();
		String meaning = scan.nextLine();
		
		//수정할 단어 인스턴스 생성
		Word newW = new Word(word, PoS, meaning);
		
		//수정할 단어가 이미 등록되어있는지 확인해서 있으면 알림 후 종료
		if(list.contains(newW)) {
			System.out.println("이미 등록된 단어이므로 수정할 수 없습니다.");
			return;
		}
		//없으면
		//원래 있던 단어 삭제 후
		list.remove(index);
		//수정할 단어 인스턴스 값 추가
		list.add(newW);
		//뜻을 여러 개 저장할 수 있게 하기 위해 따로 리스트에 추가
		newW.addMean(meaning);
		
		System.out.println("단어가 수정되었습니다.");
		//확인용 코드
		System.out.println(list);
	}

	public void insertWord() {
		System.out.println("=====단어 추가=====");
		System.out.print("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		System.out.print("품사 : ");
		String PoS = scan.next();
		System.out.print("뜻 : ");
		scan.nextLine();
		String meaning = scan.nextLine();
		
		//입력받은 정보로 인스턴스 w를 생성
		Word w = new Word(word, PoS, meaning);
		
		//단어가 이미 존재하는지 확인하기 위한 인스턴스 checkW 생성
		Word checkW = new Word(word, "", "");
		
		int index = list.indexOf(checkW);
		//단어가 리스트에 있는지 확인해서 없으면(index값이 -1이면) 추가
		if(index == -1) {
			list.add(w);
			//뜻을 여러 개 저장할 수 있게 하기 위해 따로 리스트에 추가
			w.addMean(meaning);
			System.out.println("단어를 등록했습니다.");
			//확인용 코드
			System.out.println(list);
			return;
		}
		System.out.println("이미 등록된 단어입니다.");
				
	}

}
