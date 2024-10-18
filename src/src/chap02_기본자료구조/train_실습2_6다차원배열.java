package chap02_기본자료구조;

import java.util.Random;

public class train_실습2_6다차원배열 {

	public static void main(String[] args) {
		int[][] A = new int[2][3];
		int[][] B = new int[3][4];
		int[][] C = new int[2][4];
		int[][] C2 = new int[2][4];
		

		inputData(A);
		inputData(B);
		int[][] D = A.clone();// 교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println();
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		System.out.println();
		int[][] E = addMatrix(A, D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
		System.out.println();
		C = multiplyMatrix(A, B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);
		System.out.println();

		int[][] F = transposeMatrix(B);
		System.out.println("F[4][3] = ");
		showData("행렬 F", F);
		System.out.println();
		C2 = multiplyMatrixTransposed(A, F);
		showData("행렬 곱셈 결과-전치행렬 사용", C2);
		boolean same = equals(C, C2);
		if(same) {
			System.err.println("c와 c2의 결과가 같다");
		}
		else {
			System.err.println("c와 c2의 결과가 다르다.");
		}
	}

	static void inputData(int[][] data) { // 랜덤함수를 사용해서 값을 초기화.
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = rand.nextInt(10);
			}
		}
	}

	static void showData(String msg, int[][] items) { // 출력하는 메서드
		System.out.println(msg);
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[i].length; j++) {
				System.out.print(items[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean equals(int[][] a, int[][] b) { // 행렬 곱셈 결과-전치행렬 사용의 결과를 C의 원본배열과 같은지 비교하는 메서드, 하나라도 값이 다르면 false를 //
													// 반환한다.
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static int[][] addMatrix(int[][] X, int[][] Y) { // 배열 +
		int[][] num = new int[X.length][X[0].length];
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X[i].length; j++) {
				num[i][j] += X[i][j] + Y[i][j];
			}
		}
		return num;
	}

	static int[][] multiplyMatrix(int[][] X, int[][] Y) { // for문 3개 필요 y값을 인덱싱하면서 [행별 계산] 후 새로운 배열에 할당 후 새로운 배열을 리턴
		int[][] z = new int[X.length][Y[0].length];
		if (X[0].length == Y.length) { // 첫 번째 행렬의 열 수와 두 번째 행렬의 행 수가 같아야 !!
			for (int i = 0; i < X.length; i++) { // X의 각 행을 순회
				for (int j = 0; j < Y[0].length; j++) { // X의 각 열을 순회
					for (int k = 0; k < Y.length; k++) { // Y의 각 행을 순회
						z[i][j] += X[i][k] * Y[k][j]; // (X의 현재 행 i)와 (Y의 현재 열 k)의 곱을 계산하여 (z의 해당 위치)에 누적
					}
				}
			}
		}
		return z;
	}

	static int[][] transposeMatrix(int[][] X) { // 전치행렬
		int[][] transpose = new int[X[0].length][X.length]; // 원래 행렬의 반대이기 떄문에 크기를 [열][행]으로 잡아준다.
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X[0].length; j++) {
				transpose[j][i] = X[i][j];
			}
		}
		return transpose;
	}

	static int[][] multiplyMatrixTransposed(int[][] X, int[][] Y) { // 전치행렬이 완료된 B[][]배열을 사용하여 A와 F를
		int[][] num = new int[X.length][Y.length]; // 담을 배열 만들기
		if (X[0].length == Y[0].length) {
			for (int i = 0; i < X.length; i++) { // x의 각 행을 순회
				for (int j = 0; j < X[0].length; j++) { // x의 각 열을 순회
					for (int k = 0; k < Y.length; k++) { // y의 각 열을 순회
						num[i][k] += X[i][j] * Y[k][j];
					}
				}
			}

		}
		return num;
	}

}
