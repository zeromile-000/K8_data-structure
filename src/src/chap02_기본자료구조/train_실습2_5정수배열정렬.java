package chap02_기본자료구조;

/*
 * 2장 과제2 - 정수 배열 정렬
 * 배열의 크기는 20개, top 변수가 현재 배열에 저장된 갯수를 저장 
 */
import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;

public class train_실습2_5정수배열정렬 {
	static int top = 0;
	static final int MAX_LENGTH = 20;

	public static void main(String[] args) {
		float[] data = new float[MAX_LENGTH];// 0.0 ~ 1.0 사이의 실수를 저장
		inputData(data, 10);// 10개의 난수를 입력
		showData("실수 난수 입력", data);// top 개수 만큼 출력

		reverse(data);// 역순으로 재배치 - 교재 67페이지 참조
		showData("역순 재배치", data);
		System.out.println(Arrays.toString(data));// 교재 84페이지 코드 참조
		showData("실수 스트링의 정렬", data);
		sortData(data);// 교재 205 bubbleSort() 함수 코드를 사용 - 올림차순으로 정렬 : 왼쪽값이 오른쪽 값 보다 작아야 한다. ex) a[4] <
						// a[5];
		showData("버블정렬", data);
		Random rand = new Random();
		float realData = rand.nextFloat();
		float[] x = insertData(data, realData);// 입력 실수보다 큰 숫자를 우측으로 이동
		showData("실수 삽입후", x);
	}

	static void showData(String s, float m[]) {// 실수 배열을 top 갯수만 출력 (top까지만 출력)
		System.out.println(s);
		for (int i = 0; i < top; i++) {
			System.out.print(m[i] + " ");
		}
		System.out.println();
	}

	static void inputData(float[] arr, int num) {
		Random rand = new Random();
		for (int i = 0; i < num; i++) {
			arr[i] = rand.nextFloat();
			// 난수 실수를 입력
			top += 1;
		}
	}

	static void reverse(float[] arr) {// 역순으로 재배치 - top 갯수만 역순 재배치 책에 그대로 있음
		for (int i = 0; i < top / 2; i++) {
			swap(arr, i, top - 1 - i);
		}
	}

	static void swap(float[] data, int i, int j) {// 교재 67페이지 - 맞교환 그대로 있음
		float a = data[i];
		data[i] = data[j];
		data[j] = a;
	}

	static void sortData(float[] data) {// 올림차순으로 정렬 - top 갯수를 사용 (반복문의 end) if < [] 비교 변수가 필요
		for (int i = 0; i < top - 1; i++) {
			for (int j = top - 1; j > i; j--) {
				if (data[j - 1] > data[j]) {
					swap(data, j - 1, j);
				}
			}
		}

	}

	static float[] insertData(float[] data, float num) {// insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		float[] neww = new float[top + 1];
		int i = 0;
		while (data[i] < num) {
			neww[i] = data[i];
			i++;
		}
		neww[i] = num;
		for (int j = i + 1; j < neww.length; j++) {
			neww[j] = data[j - 1];
		}
		return neww;

	}

}
