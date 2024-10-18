package Chap3_검색;

/*
 * 3장 2번 실습과제 - 스트링 배열의 정렬과 이진검색 
* 교재 121 실습 3-6 
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;

public class train_실습3_6_0스트링배열정렬이진탐색 {
	static void showData(String n, String[] data) {
		System.out.println(n);
		for (String ns : data) {
			System.out.print(ns + " ");
		}
		System.out.println();
	}

	static void sortData(String[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int min = i; // 현재 위치를 최솟값 인덱스로 설정
			for (int j = i + 1; j < data.length; j++) {
				if (data[j].compareTo(data[min]) < 0) {
					min = j; // 새로운 최솟값 인덱스 업데이트
				}
			}
			if (min != i) {
				String temp = data[i];
				data[i] = data[min];
				data[min] = temp;
			}
		}
	}
	
	static int linearSearch(String[] data, String key) {
		int i = 0;
		while (true) {
			if (i >= data.length)
				return -1;
			if (data[i] == key)
				return i;
			i++;
		}
	}
	static int binarySearch(String[] data, String key) {
		int pl = 0; // 검색 범위의 첫 번째 인덱스 
		int pr = data.length - 1; // 검색 범위의 마지막 인덱스
		
		do { // 무조건 실행
			int pc = (pl+pr) / 2; // 중앙 요소의 인덱스
			if(data[pc].compareTo(key) == 0) // 중앙요소의 인덱스가 key와 같으면
				return pc; // pc를 반환
			else if(data[pc].compareTo(key)<0) // 아니면, 중앙요소가 key보다 작으면 
				pl = pc + 1; // pc에 1을 더한 값을 pl에 대입
			else // 위 조건을 아무것도 만족하지 않으면 
				pr = pc -1; // pc를 -1하고 pr에 대입
			} while (pl <= pr); // pr이 pl보다 크거나 같으면 반복 
		return -1; // 인덱스 범위를 넘어서면 -1을 반환
	}

	public static void main(String[] args) {
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};
		showData("정렬전", data);
		sortData(data);//올림차순으로 정렬 교재211-212 단순 선택 정렬 알고리즘으로 구현
		showData("정렬후", data);

		String key = "포도";
		int resultIndex = linearSearch(data, key);//교재 100 페이지 seqSearch() 함수로 구현
		System.out.println("\nlinearSearch(포도): key = " + key + ", result 색인 = " + resultIndex);

		key = "배";
		resultIndex = binarySearch(data, key);//교재 109 페이지 binSearch() 함수로 구현
		System.out.println("\nbinarySearch(배):key = " + key + ",  result = " + resultIndex);
//		/*
//		 * 교재 115 Arrays.binarySearch에 의한 검색
//		 */
		key = "산딸기";
		resultIndex = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(산딸기): key = " + key + ", result = " + resultIndex);
	}
}

