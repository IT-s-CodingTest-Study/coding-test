import java.io.*;
import java.util.*;

public class 문자열_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 줄 입력: N은 집합 S의 문자열 수, M은 검사할 문자열 수
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 집합 S 저장하는 HashSet
        Set<String> set = new HashSet<>();

        // 집합 S의 문자열 입력받아 저장
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int count = 0; // 집합에 포함된 문자열 개수

        // 검사할 문자열을 하나씩 받아서 집합에 포함되어 있으면 count 증가
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                count++;
            }
        }

        sb.append(count).append('\n');
        System.out.print(sb);
    }
}
