package Chap3_검색;

/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
*/
import java.util.Arrays;
import java.util.Random;

class A implements Comparable<A> {
	int num;

	@Override
	public int compareTo(A c) {
		return num - c.num;
	}

	@Override
	public boolean equals(Object c) {
		if (num == ((A) c).num)
			return true;
		return false;
	}
}

public class train_실습3_4정수배열이진탐색 {
	public static void main(String[] args) {
		
		Object obj = new Object();
		obj.equals(obj);
		A ax = new A();
		A bx = new A();
		if (ax.equals(bx)) {
			
		}
		
		int []data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성

		showList("정렬 전 배열[]:: ", data);
		Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련
		Random ra = new Random();
		int key = ra.nextInt(100);
		int resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search는 없기 때문에 구현해야 한다 
		System.out.println("\nlinearSearch(13): key = " + key + ", result = " + resultIndex);

		key = ra.nextInt(100);
		/*
		 * 교재 109~113
		 */
		int resultIndexs = binarySearch(data, key);//함수 구현이 필요
		System.out.println("\nbinarySearch(19): key = " + key + ", result = " + resultIndexs);
		
		key = ra.nextInt(100);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);
		
		System.out.println("\nArrays.binarySearch(10): result = " + resultIndex);

	}

	static void inputData(int[] data) {
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100);
		}
	}

	static void showList(String ns, int[] data) {
		System.out.print(ns);
		for (int n : data) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	static int linearSearch(int[] data, int key) {
		int i = 0;
		while (true) {
			if (i >= data.length)
				return -1;
			if (data[i] == key)
				return i;
			i++;
		}
	}
//	배열의 중간 요소를 확인합니다. a
//	중간 요소가 찾고자 하는 값과 일치하면 해당 인덱스를 반환합니다.
//	중간 요소가 찾고자 하는 값보다 크면 오른쪽 절반을 무시하고 왼쪽 절반에서 계속 검색합니다.
//	중간 요소가 찾고자 하는 값보다 작으면 왼쪽 절반을 무시하고 오른쪽 절반에서 계속 검색합니다.
//	이 과정을 반복하다가 값을 찾거나 탐색 범위가 사라질 때까지 진행합니다.
	static int binarySearch(int[] data, int key) {
		int pl = 0; // 검색 범위의 첫 번째 인덱스 
		int pr = data.length - 1; // 검색 범위의 마지막 인덱스
		
		do { // 무조건 실행
			int pc = (pl+pr) / 2; // 중앙 요소의 인덱스
			if(data[pc] == key) // 중앙요소의 인덱스가 key와 같으면
				return pc; // pc를 반환
			else if(data[pc]<key) // 아니면, 중앙요소가 key보다 작으면 
				pl = pc + 1; // pc에 1을 더한 값을 pl에 대입
			else // 위 조건을 아무것도 만족하지 않으면 
				pr = pc -1; // pc를 -1하고 pr에 대입
			} while (pl <= pr); // pr이 pl보다 크거나 같으면 반복 
		return -1; // 인덱스 범위를 넘어서면 -1을 반환
	}
}
