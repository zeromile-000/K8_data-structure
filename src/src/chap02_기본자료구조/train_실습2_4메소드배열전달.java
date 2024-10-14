package chap02_기본자료구조;
/*
 * 2장과제1: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */

import java.util.Random;

public class train_실습2_4메소드배열전달 {
	public static void main(String[] args) {
		int[] data = new int[10]; // [0,0,0,0,0,0,0,0,0,0]
		inputData(data);
		showData("소스데이터", data);
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
		reverse(data);// 역순으로 출력
		showData("역순 데이터", data);
	}

	public static void showData(String str, int[] arr) {
		System.out.println(str);
		for (int arrs : arr) {
			System.out.println(arrs);
		}
	}

	static void inputData(int[] arr) {// 교재 63 - 난수의 생성
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) 
			arr[i] = rand.nextInt(10);
	}

	static int findMax(int[] ars) { // 최대값을 리턴한다
		int num = 0;
		for (int i = 0; i < ars.length; i++) {
			if (ars[i] > num) {
				num = ars[i];
			}
		}
		return num;
	}

	static boolean findValue(int[] arr, int num) { 		//items[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false로 리턴
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	static void reverse(int[] arr) {
		for(int i = 0; i<arr.length/2;i++) {
			swap(arr,i,arr.length-i-1);
		}
	}

	static void swap(int[] data, int i, int j) {
		int a = data[i]; 
		data[i] = data[j];
		data[j] = a;
	}

}
