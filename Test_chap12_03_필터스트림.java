package 자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//12장 입출력 파일
public class Test_chap12_03_필터스트림 {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("이름을 입력하세요");
			String name = br.readLine();
			System.out.println("Hello " + name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}