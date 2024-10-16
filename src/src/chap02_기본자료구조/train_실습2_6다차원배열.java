package chap02_기본자료구조;

import java.util.Random;
public class train_실습2_6다차원배열 {

	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];

		inputData(A);inputData(B);
		int [][]D = A.clone();//교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		int [][]E = addMatrix(A,D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
		C = multiplyMatrix(A,B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);

		int [][]F = transposeMatrix(B);
		System.out.println("F[3][2] = ");
		showData("행렬 F", F);
		C= multiplyMatrixTransposed(A,F);
		showData("행렬 곱셈 결과-전치행렬 사용", C);
	}
	static void inputData(int [][]data) { // 랜덤함수를 사용해서 값을 초기화.
		Random rand = new Random();
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; i++) {
				data[i][j] = rand.nextInt();	
			}
		}
			
	
	}
	static void showData(String msg, int[][]items) { // 출력하는 메서드
		System.out.println(msg);
		for(int i = 0; i < items.length; i++) {
			for(int j = 0; j < items[i].length; j++) {
				System.out.print(items[i][j]);
			}
		}

	}
	static boolean equals(int[][]a, int[][]b) { //해
		for(int i = 0; i < a.length; i)
		
		return false;  


	}
	static int[][] addMatrix(int [][]X, int[][]Y) { // 배열 +

	}
	static int[][] multiplyMatrix(int [][]X, int[][]Y) { // for문 3개 필요  y값을 인덱싱하면서 [행별 계산] 후 새로운 배열에 할당 후 새로운 배열을 리턴

		
	}
	static int[][] transposeMatrix(int [][]X) { // 전치행렬 

		
	}
	static int[][] multiplyMatrixTransposed(int [][]X, int[][]Y){   //multiplyMatrix 
		
	}
}

