package chap1_기본알고리즘;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 실습1_6_스트링토큰_과제 {
	/*
	 * StringTokenizer(input), countTokens(), hasMoreTokens(), nextToken()
	 * parseDouble(stringArray[i])
	 */
	// 문자열을 실수로 추출하여 배열에 저장하고 정렬하는 함수
	public static String[] extractSortStrings(String str) {
		StringTokenizer str1 = new StringTokenizer(str);
		String st[] = new String[str1.countTokens()];
		int x = 0;
		while (str1.hasMoreTokens()) {
			st[x++] = str1.nextToken();
		}
		Arrays.sort(st);
		return st;

	}

	// 문자열 배열을 실수 배열로 변환한 후 정렬하는 함수
	public static double[] convertSortToDouble(String str[]) {
		double[] num = new double[str.length];
		for (int i = 0; i < str.length; i++) {
			num[i] = Double.parseDouble(str[i]);
		}
		Arrays.sort(num);
		return num;
	}

	// 문자열 배열 출력 함수
	public static void printStringArray(String[] str) {
		for (String st : str) {
			System.out.println(st);
		}
	}

	// 실수 배열 출력 함수
	public static void printDoubleArray(double[] n) {
		for (double nx : n) {
			System.out.println(nx);
		}
	}

	public static void main(String[] args) {
		String msg = "3.24 3.34156 1141.56 214. 0.0314156 54.12f";

		// 실수를 문자열로 추출하고 정렬 후 출력
		String[] sortedStringArray = extractSortStrings(msg);
		System.out.println("정렬 스트링 배열:");
		printStringArray(sortedStringArray);

		// 문자열 배열을 실수 배열로 변환하고 정렬 후 출력
		double[] sortedDoubleArray = convertSortToDouble(sortedStringArray);
		System.out.println("정렬 실수 배열:");
		printDoubleArray(sortedDoubleArray);
	}
}
