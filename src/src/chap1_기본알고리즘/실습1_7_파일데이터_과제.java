package 자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class 실습1_7_파일데이터_과제 {
/*
 * trim(),split(" ")
 */
    // 파일을 읽어 각 라인을 공백으로 분리하여 정렬하는 함수
    public static String[] readSortFromFile(String filename) {
    	// 저장할 데이터
        String data = "12 1 131 2 23";
        String data2 = " 312 32 8 22 7";
        // 파일에 데이터 쓰기
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // 데이터를 파일에 씀
        	writer.write(data);
        	writer.write(data2);
            
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류 발생: " + e.getMessage());
        }
        
        StringBuilder sb = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // 라인을 읽어서 StringBuilder에 추가
        	String r = "";
        	while((r=br.readLine()) != null) {
        		sb.append(r);
        	}
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 공백으로 구분된 서브스트링을 배열로 변환하고 정렬
        String[] str = sb.toString().trim().split(" ");
        Arrays.sort(str);
        
        // 정렬된 배열 반환
        return str;
    }

    // 문자열 배열을 정수 배열로 변환하고 정렬하는 함수
    public static int[] convertSortToInt(String[] str) {
    	int[] nu = new int[str.length];
    	for(int i = 0; i<str.length;i++) {
    		nu[i] = Integer.parseInt(str[i]); 
    	}
    	Arrays.sort(nu);
    	return nu;
    }

    // 문자열 배열 출력 함수
    public static void printStringArray(String[] str) {
    	for(String st:str) {
    		System.out.println(st);
    	}
    }

    // 정수 배열 출력 함수
    public static void printIntArray(int[] num) {
    	for(int n:num) {
    		System.out.println(n);
    	}
    }
  

    public static void main(String[] args) {
        String filename = "C:\\Users\\HOME\\OneDrive - 동의대학교\\바탕 화면\\자료구조\\자료구조\\src\\자료구조\\data.txt";  // 파일 이름 설정 (실제 파일 경로로 변경)

        // 파일에서 읽어온 문자열 배열을 정렬 후 출력
        String[] sortedStringArray = readSortFromFile(filename);
        System.out.println("Sorted String Array from File:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환하고 정렬 후 출력
        int[] sortedIntArray = convertSortToInt(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }
}
