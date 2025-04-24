import java.io.*;
import java.util.*;

public class 풍선_터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 풍선 수
        String[] input = br.readLine().split(" ");

        // 풍선 정보 저장 [번호, 이동값]
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int move = Integer.parseInt(input[i]);
            deque.add(new int[] { i + 1, move }); // [번호, 이동값]
        }

        while (!deque.isEmpty()) {
            // 풍선 하나 터뜨림
            int[] current = deque.pollFirst(); // 앞에서 꺼냄
            int move = current[1];
            sb.append(current[0]).append(" "); // 풍선 번호 기록

            if (deque.isEmpty())
                break; // 마지막 풍선이면 종료

            // 이동
            if (move > 0) {
                // move - 1번 앞에서 꺼내 뒤로 보냄
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                // move번 뒤에서 꺼내 앞으로 보냄
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}
