import java.io.*;

public class 세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] lines = new String[5]; // 단어 5줄 저장
        int maxLength = 0; // 가장 긴 문자열 길이 저장

        for (int i = 0; i < 5; i++) {
            lines[i] = br.readLine();
            if (lines[i].length() > maxLength) {
                maxLength = lines[i].length();
            }
        }

        // 열 우선 순회 (세로 읽기)
        for (int col = 0; col < maxLength; col++) {
            for (int row = 0; row < 5; row++) {
                // 해당 줄에 해당 열 문자가 존재할 때만 출력
                if (col < lines[row].length()) {
                    sb.append(lines[row].charAt(col));
                }
            }
        }

        // 결과 출력
        System.out.println(sb);
    }
}
