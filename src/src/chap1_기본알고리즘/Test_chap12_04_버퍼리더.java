package 자료구조;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class Test_chap12_04_버퍼리더 {

    public static void main(String[] args) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("a.txt"));
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
             
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
            }

            byte[] arr = out.toByteArray();
            String s = new String(arr, 0, arr.length); // 배열의 유효한 길이만큼 변환
            System.out.println("파일 내용:");
            System.out.println(s);

            // 문자열을 쉼표와 줄바꿈으로 분리
            String[] sa = s.split(",|\n");
            System.out.println("분리된 문자열:");
            for (String x : sa) {
                x = x.trim();
                if (!x.isEmpty()) { // 빈 문자열은 출력하지 않음
                    System.out.print(" " + x);
                }
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
