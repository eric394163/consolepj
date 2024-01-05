/* To-Do
 * 1. 파일에 데이터 저장하고 불러오기 확인
 * 2. 많이 검색한 단어 보여주는 기능 만들기
 * 3. 기타 추가 기능 만들기 (게임, 오답노트)
 * 4. contains 이용하기 (equals 대체)
 * 
 * */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class WordProgram implements Program{	
	/* 영어 단어장을 관리하는 프로그램을 작성하세요
	 * 한 단어에 뜻이 여러 개 있을 수 있음
	 * 단어, 품사, 뜻을 관리
	 * 단어 추가
	 * 단어 수정
	 * 단어 삭제
	 * 뜻 추가
	 * 뜻 수정
	 * 뜻 삭제
	 * 단어 조회
	 * 
	 * 기타 추라
	 * - 등록된 단어에서 랜덤으로 문제가 나오고 나오는 기능
	 * - 오답노트를 관리하는 기능
	 * - 많이 조회한 단어를 확인하는 기능*/
	
	private Scanner scan= new Scanner(System.in);
	private static List<Word> list = new ArrayList<Word>();
	String fileName = "src/vocabulary/voca.txt";

	@Override
	public void run() {
		load(fileName);
		System.out.println("------------------");
		System.out.println("프로그램을 실행합니다.");
		System.out.println("------------------");
		int menu=0;
		
		printAll();
		
		while(menu!=5) {
			printMenu();
			try {
				menu = scan.nextInt();
				scan.nextLine();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
			
		}
	}

	

	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 단어 조회");
		System.out.println("5. 종료");
		System.out.print("메뉴 입력: ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertWord(list);
			System.out.println("--단어 추가--");
			break;
		case 2:
			System.out.println("--단어 수정--");			
			System.out.println("1. 뜻 추가");
			System.out.println("2. 뜻 수정");
			System.out.println("3. 뜻 삭제");
			int menu2 = scan.nextInt();
			scan.nextLine();
			switch(menu2) {
			case 1:
				printList();
				insertMeaning();
				break;
			case 2:
				printList();
				editMeaning();
				break;
			case 3:
				printList();
				deleteMeaning();
				break;
			default:
				System.out.println();
			}
			break;
		case 3:
			removeWord();
			break;
		case 4:
			System.out.println("--단어 조회--");
			System.out.println("1. 단어 검색");
			System.out.println("2. 많이 검색한 단어");
			int menu4 = scan.nextInt();
			scan.nextLine();
			switch(menu4) {
			case 1:
				searchWord();
				break;
			case 2:
				searchRank();
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
					
			}
			break;
		case 5:
			save(fileName);
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}

	private void searchRank() {
		sort(); // 많이 검색한 순서 대로 단어 정렬하기
		Word tmp;
		for(int i =1 ; i < 5; i++) { // 가장 많이 검색한 단어 위에서 5개만 출력하기
			try{
				tmp = list.get(list.size()-i);
				System.out.print(i+". " );
				tmp.printInfo();
				System.out.println(tmp.getSearchNum()+"번 검색");
			}catch(IndexOutOfBoundsException e) {
				break;
			}
			
		}
		
	}



	private void removeWord() {
		
		System.out.println("--단어 삭제--");
		printList();
		System.out.println("----------------");
		System.out.print("삭제할 단어 (스펠링): "); String word = scan.next();
		System.out.print("품사 (ex. 형, 명, 동, 전, 관): "); char type = scan.next().charAt(0);
		Word tmp = new Word(word, type);
		if(list.contains(tmp)) {
			list.remove(tmp);
			
			System.out.println("삭제 완료.");
			printList();
			return;
		}
		System.out.println("등록되지 않은 뜻입니다.");
	}

	private void searchWord() {
		
		System.out.println("--단어 검색--");
		System.out.print("단어 (스펠링): "); String word = scan.next();
		System.out.print("품사 (ex. 형, 명, 동, 전, 관): "); char type = scan.next().charAt(0);

		
		Word tmp = new Word(word, type);
		if(list.contains(tmp)) {
			int num = list.indexOf(tmp);
			Word std = list.get(num);
			std.searchWord();
			return;
		}
		
		System.out.println("등록되지 않은 단어입니다.");
		
	}

	private void deleteMeaning() {
		
		System.out.println("--단어 뜻 삭제--");
		System.out.print("단어 (스펠링): "); String word = scan.next();
		System.out.print("품사 (ex. 형, 명, 동, 전, 관): "); char type = scan.next().charAt(0);

		Word tmp = new Word(word, type);
		if(list.contains(tmp)) {
			System.out.print("삭제할 뜻 입력: ");
			String stdMean = scan.next();

			int num = list.indexOf(tmp);
			Word std = list.get(num);
			
			//만약 이미 있는 뜻으로 바꾸려고 하면 막는 코드 작성하기
			std.removeMean(stdMean);
			
			System.out.println("삭제 완료.");
			std.printInfo();
			return;
		}
		
		System.out.println("등록되지 않은 뜻입니다.");
		
		
	}

	private void editMeaning() {
		
		System.out.println("--단어 뜻 수정--");
		System.out.print("단어 (스펠링): "); String word = scan.next();
		System.out.print("품사 (ex. 형, 명, 동, 전, 관): "); char type = scan.next().charAt(0);

		Word tmp = new Word(word, type);
		if(list.contains(tmp)) {			
			System.out.print("수정할 뜻 입력: ");
			String stdMean = scan.next();
			System.out.print("새로운 뜻 입력: ");
			String newMean = scan.next();
			
			int num = list.indexOf(tmp);
			Word std = list.get(num);
			
			//만약 이미 있는 뜻으로 바꾸려고 하면 막는 코드 작성하기
			std.removeMean(stdMean);
			std.addMean(newMean);
			
			System.out.println("수정 완료.");
			std.printInfo();
			return;
		}
		
		System.out.println("등록되지 않은 단어입니다.");
		
	}

	private void printList() {
		System.out.println("-------------");
		System.out.println("<단어 목록>: ");
		for(int i=0; i<list.size(); i++) {
			Word std = list.get(i);
			System.out.print((i+1)+". ");
			std.printInfo();
		}
		System.out.println("-------------");
	}

	private void insertMeaning() {
		
		System.out.println("--단어 뜻 추가--");
		System.out.print("단어 (스펠링): "); String word = scan.next();
		System.out.print("품사 (ex. 형, 명, 동, 전, 관): "); char type = scan.next().charAt(0);

		Word tmp = new Word(word, type);
		if(list.contains(tmp)) {			
			System.out.print("새로운 뜻 입력: ");
			String newMean = scan.next();
			
			int num = list.indexOf(tmp);
			Word std = list.get(num);
			
			std.addMean(newMean);
			
			System.out.println("추가 완료.");
			std.printInfo();
			return;
		
		}
		System.out.println("등록되지 않은 단어입니다.");
	}

	private void insertWord(List<Word> list) {
		System.out.println("--단어 추가--");
		System.out.print("단어 스펠링: "); String word = scan.next();
		System.out.print("품사 (ex. 형, 명, 동, 전, 관): "); char type = scan.next().charAt(0);
		
		Word tmp = new Word(word, type);
		
		if(type!='형'&&type!='명'&&type!='동'&&type!='전'&&type!='관') {
			System.out.println("잘못된 품사입니다. 다시 입력하세요.");
			insertWord(list);
		}
		
		System.out.print("단어 뜻 (대포 뜻 1개): "); String meaning = scan.next();
		
		
		if(list.contains(tmp)) {
			System.out.println("이미 등록된 단어입니다.");
			return;
		}
		
		tmp.addMean(meaning);;
		
		list.add(tmp);
		System.out.println("\n단어 추가가 완료되었습니다.\n");
		tmp.printInfo();
		return;
		
	}
	
	public void sort() {
		list.sort((s1, s2)-> {
			//학년이 다르면
			if(s1.getSearchNum() != s2.getSearchNum()) {
				return s1.getSearchNum() - s2.getSearchNum();
			}
			return s1.getSearchNum() - s2.getSearchNum();
		});
		System.out.println("단어를 정렬하였습니다.");
	}
	
	
	public void printAll() {
		list.stream().forEach(s->System.out.println(s));
	}
	
	
	
	private static void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");
		}

	}
	
	private void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
				list = (List<Word>)ois.readObject();
				System.out.println("기존 정보를 불러왔습니다.");
			}catch(java.io.EOFException e) {
				System.out.println("기존 정보가 없습니다.");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("불러오기에 실패했습니다.");
			}
	}
}
	


