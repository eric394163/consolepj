package Test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordProgram implements Program{
	
	private static Scanner scan = new Scanner(System.in);
	private final int EXIT = 5;
	private static List<Word> list = new ArrayList<Word>();
	
	public void run() {
		
		int menu=0;
		
		do {
			printMenu();
			try {
			menu = scan.nextInt();
			
			runMenu(menu); }
			
		catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != EXIT);
		
	}

	public void runMenu(int menu) {
		switch(menu) {
		
		case 1:
			wordManager(); //단어관리
			break;
			
		case 2:
			meanManager(); //뜻 관리
			break;
			
		case 3:
			wordSearch(); // 단어 조회
			break;
			
		case 4:
			randomGame(); //랜덤게임
			break;
			
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
			
			default :
				throw new InputMismatchException();
		}
	}
	
	private void randomGame() {
		
		//저장된 단어가 없으면 없다고 출력
		if (list.isEmpty()) {
	        System.out.println("저장된 단어가 없습니다.");
	        return;
	    }
		
		//저장된 단어를 랜덤으로 출력
		Collections.shuffle(list, new Random());
		
		for (Word word : list) {
			System.out.println("단어: " + word.getWord());
			
			//사용자가 뜻 입력
			 System.out.print("뜻 입력: ");
			 String userAnswer = scan.next();
			 
			 //출력 된 단어와 사용자가 입력한 뜻이 맞으면 정답
			 if (userAnswer.equals(word.getMean())) {
		            System.out.println("정답입니다.");
		            //아닐 시 오답
		        } else {
		            System.out.println("오답입니다. 정답은 " + word.getMean() + "입니다.");
		        }
			 
			 System.out.print("계속 하시겠습니까? (y/n): ");
		        String continueGame = scan.next();

		        if (!continueGame.equals("y")) {
		            System.out.println("게임을 종료합니다.");
		            break;
		        }

		}
		
		
	}

	private void wordSearch() {
		if (list.isEmpty()) {
	        System.out.println("저장된 단어가 없습니다.");
	        return;
	    }

	    System.out.println("저장된 단어 목록:");

	    //알파벳 순 정렬
	    list.sort((word1, word2) -> word1.getWord().compareToIgnoreCase(word2.getWord()));

	    for (Word word : list) {
	        System.out.println(word.getWord() + " - " + word.getMean());
	    }
		
	}

	private void meanManager() {
		printMeanMenu();
		
		int menu = scan.nextInt();
		
		runMeanMenu(menu);
		
	}

	private void runMeanMenu(int menu) {
		switch(menu) {
				
				case 1:
					insertMean();
					break;
					
				case 2:
					updateMean();
					break;
					
				case 3:
					deleteMean();
					break;
					
					default :
						throw new InputMismatchException();
				}
		
	}

	private void deleteMean() {
		System.out.print("단어 :");
	    String wordStr = scan.next();

	    Word wordObj = FindWORD(wordStr);

	    if (wordObj != null) {
	        System.out.println("현재 뜻: " + wordObj.getMean());
	        System.out.print("뜻을 삭제하시겠습니까? (y/n):");
	        String confirm = scan.next();

	        if (confirm.equalsIgnoreCase("y")) {
	            wordObj.setMean(""); 
	            System.out.println("뜻이 삭제되었습니다.");
	        } else {
	            System.out.println("뜻 삭제가 취소되었습니다.");
	        }
	    } else {
	        System.out.println("등록되지 않은 단어입니다.");
	    }
		
	}

	private void updateMean() {
		System.out.print("단어 :");
	    String wordStr = scan.next();

	    Word wordObj = FindWORD(wordStr);

	    if (wordObj != null) {
	        System.out.println("현재 뜻: " + wordObj.getMean());
	        System.out.print("새로운 뜻 :");
	        String newMean = scan.next();
	        wordObj.setMean(newMean);
	        
	        System.out.println("뜻이 업데이트되었습니다.");
	    } else {
	        System.out.println("등록되지 않은 단어입니다.");
	    }
		
	}

	private void insertMean() {
		//뜻 추가
				System.out.print("뜻을 추가할 단어 :");
				String wordStr = scan.next();
					
				Word wordObj = FindWORD(wordStr);
				
				if (wordObj != null) {
				    System.out.print("뜻 :");
				    String mean = scan.next();
				    wordObj.addMean(mean); 
				    System.out.println("뜻이 등록되었습니다.");
				} else {
				    System.out.println("등록되지 않은 단어입니다.");
				}
	}

	private Word FindWORD(String targetWord) {
		
		 for (Word word : list) {
		        if (word.getWord().equals(targetWord)) {
		            return word; 
		        }
		    }
		
		return null;
	}

	private void printMeanMenu() {
		System.out.println("======뜻 관리======");
		System.out.println("1. 뜻 추가");
		System.out.println("2. 뜻 수정");
		System.out.println("3. 뜻 삭제");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
		
	}

	public static void wordManager() {
		
		printWordMenu();
		
		int menu = scan.nextInt();
		
		runWordMenu(menu);
		
	}

	private static void runWordMenu(int menu) {
		switch(menu) {
		
		case 1:
			insertWord();
			break;
			
		case 2:
			updateWord();
			break;
			
		case 3:
			deleteWord();
			break;
			
			default :
				throw new InputMismatchException();
		}
		
	}

	private static void deleteWord() {
		
		System.out.print("삭제할 단어 :");
		String word = scan.next();
		
		Word wrd = new Word(word, "");
		
		if(list.remove(wrd)) {
			System.out.println("단어가 삭제 되었습니다.");
		}else {
			System.out.println("등록되지 않은 단어입니다.");
		}
	}

	private static void updateWord() {
		//단어수정
		System.out.print("단어 :");
		String word = scan.next();
		
		Word wrd = new Word(word, "");
		int index = list.indexOf(wrd);
		
		if(index == -1) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		
		wrd = list.get(index);
		
		System.out.print("수정할 단어 :");
		word = scan.next();
		
		Word newwrd = new Word(word, "");
		
		if(list.contains(newwrd)) {
			System.out.println("이미 등록된 단어이기 때문에 수정할 수 없습니다.");
			return;
		}
		
		newwrd.setMean(wrd.getMean());
		
		list.remove(index);
		
		list.add(newwrd);
		
		System.out.println("단어가 수정 되었습니다.");
	}

	private static void insertWord() {
		//단어추가
		System.out.print("단어 :");
		String word = scan.next();
		
		Word wrd = new Word(word, "");
		
		try {
			if(!list.contains(wrd)) {
				list.add(wrd);
				System.out.println("단어가 등록 됐습니다.");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("이미 등록된 단어입니다.");
	}

	private static void printWordMenu() {
		System.out.println("======단어관리======");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
		
	}

	public void printMenu() {
		System.out.println("================");
		System.out.println("1. 단어 관리");
		System.out.println("2. 뜻 관리");
		System.out.println("3. 단어 조회");
		System.out.println("4. 단어 게임");
		System.out.println("5. 프로그램 종료");
		System.out.println("================");
		System.out.print("메뉴 선택 : ");
	}


}