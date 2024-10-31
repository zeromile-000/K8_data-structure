//package Chap4_스택과큐;
///*
// * 과제1. 정수 배열 스택 
// * 교재에 있는 소스코드, 교재 133 실습 4-1 - 정수 배열로 스택 구현
// * 입력하여 실행 실습
// * 정수형 스택 소스 코드
// * 객체스택과 큐에 대한 구현도 정수 스택의 예외처리 방식을 반복 적용함 
// */
//
//import java.util.Scanner;
//
////int형 고정 길이 스택
//
//class IntStack3 {
//	private int[] stk; // 스택용 배열
//	private int capacity; // 스택의 크기(용량)
//	private int ptr; // 스택 포인터
//
////--- 실행시 예외: 스택이 비어있음 ---//
//	public class EmptyIntStackException extends RuntimeException {
//		public EmptyIntStackException(String message) {
//			super(message);
//		}
//	}
//
////--- 실행시 예외: 스택이 가득 참 ---//
//	public class OverflowIntStackException extends RuntimeException {
//		public OverflowIntStackException(String message) {
//			super(message);
//		}
//	}
//
////--- 생성자(constructor) ---//
//	public IntStack3(int maxlen) {
//		capacity = maxlen;
//		try {
//			stk = new int[capacity]; //메모리 할당 - 메모리가 부족하면 예외 발생			
//		} catch(OutOfmemory e) {
//			
//			
//		}
//		ptr = 0;
//
//	}
//
////--- 스택에 x를 푸시 ---//
//	public int push(int x) throws OverflowIntStackException {
//		if (ptr >= capacity) // 스택이 가득 참
//			throw new OverflowIntStackException("push: stack overflow");
//		return stk[ptr++] = x;
//	}
//
////--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
//	public int pop() throws EmptyIntStackException {
//		if(ptr <= 0) 
//			throw new EmptyIntStackException();
//		return stk[--ptr];
//		
//
//	}
//
////--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
//	public int peek() throws EmptyIntStackException {
//		
//		return stk[ptr-1]; // 맨 마지막 값을 가져옴
//
//	}
//
////--- 스택을 비움 ---//
//	public void clear() {
//		ptr = 0;
//	}
//
////--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
//	public int indexOf(int x) {
//
//	}
//
////--- 스택의 크기를 반환 ---//
//	public int getCapacity() {
//		return capacity;
//	}
//
////--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
//	public int size() {
//		return ptr;
//	}
//
////--- 스택이 비어있는가? ---//
//	public boolean isEmpty() {
//		return ptr <= 0;
//	}
//
////--- 스택이 가득 찼는가? ---//
//	public boolean isFull() {
//		return ptr >= capacity;
//	}
//	
////--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
//	public void dump() throws EmptyIntStackException{
//
//	}
//}
//
//public class 실습4_2정수스택 {
//
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		IntStack3 s = new IntStack3(4); // 최대 64 개를 푸시할 수 있는 스택
//
//		while (true) {
//			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
//			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
//			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");
//
//			int menu = stdIn.nextInt();
//			if (menu == 0)
//				break;
//
//			int x;
//			switch (menu) {
//
//			case 1: // 푸시
//				System.out.print("데이터: ");
//				x = stdIn.nextInt();
//				try {
//					s.push(x);
//				} catch (IntStack3.OverflowIntStackException e) {
//					System.out.println("스택이 가득 찼습니다." + e.getMessage());
//					e.printStackTrace();
//				}
//				break;
//
//			case 2: // 팝
//				try {
//					x = s.pop();
//					System.out.println("팝한 데이터는 " + x + "입니다.");
//				} catch (IntStack3.EmptyIntStackException e) {
//					System.out.println("스택이 비어있습니다." + e.getMessage());
//					e.printStackTrace();
//				}
//				break;
//
//			case 3: // 피크
//				try {
//					x = s.peek();
//					System.out.println("피크한 데이터는 " + x + "입니다.");
//				} catch (IntStack3.EmptyIntStackException e) {
//					System.out.println("스택이 비어있습니다." + e.getMessage());
//					e.printStackTrace();
//				}
//				break;
//
//			case 4: // 덤프
//				try {
//					s.dump();
//				} catch (IntStack3.EmptyIntStackException e) {
//					System.out.println("스택이 비어있습니다." + e.getMessage());
//					e.printStackTrace();
//				}
//				s.dump();
//				break;
//			}
//		}
//	}
//}