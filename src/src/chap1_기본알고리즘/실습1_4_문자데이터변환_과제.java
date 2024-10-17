package chap1_기본알고리즘;

import java.util.Arrays;

public class 실습1_4_문자데이터변환_과제 {
/*
 * valueOf(boolVal) : 단일 매개변수만 변환가능
 * Arrays.sort(array) : 배열을 정렬해주는 Arrays 메서드
 */
    // 값을 문자열로 변환하여 배열에 저장하는 함수
    public static String[] convertValuesToString(boolean n, char n1, double n2, int n3, double n4) {
    	String t1 = String.valueOf(n);
    	String t2 = String.valueOf(n1);
    	String t3 = String.valueOf(n2);
    	String t4 = String.valueOf(n3);
    	String t5 = String.valueOf(n4);
    	String[] t6 = {t1,t2,t3,t4,t5};
    	return t6;
    } 

    // 배열을 정렬하는 함수
    public static String[] sortStringArray(String[] str) {
    	Arrays.sort(str);
    	return str;
    }

    // 배열을 출력하는 함수
    public static void showAllString(String[] str) {
    	for(String str1: str) {
    		System.out.println(str1);
    	}
    }
    
    public static void main(String[] args) {
        // 정수, float, double, boolean 값을 문자열로 변환하여 배열에 저장
        String[] stringArray = convertValuesToString(true, 'A', 3.14, 123, 45.67f);
        
        // 정렬 전 배열 출력
        System.out.println("정렬전:");
        showAllString(stringArray);
        
        // 배열 정렬
        sortStringArray(stringArray);
        
        // 정렬 후 배열 출력
        System.out.println("\n정렬후:");
        showAllString(stringArray);
    }
}

