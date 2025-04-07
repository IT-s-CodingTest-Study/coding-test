package 월;

import java.io.*;
import java.util.*;

public class Main {
    static class Balloon {
        int index;
        int move;

        public Balloon(int index, int move) {
            this.index = index;
            this.move = move;
        }
    }

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Deque<Balloon> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int move = Integer.parseInt(input[i]);
            deque.add(new Balloon(i + 1, move));  // 1번부터 시작하도록
        }

        while (!deque.isEmpty()) {
            Balloon current = deque.pollFirst();  // 풍선 터뜨림
            sb.append(current.index).append(" ");

            if (deque.isEmpty()) break;

            int move = current.move;

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());  // 오른쪽으로 이동
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    deque.addFirst(deque.pollLast());  // 왼쪽으로 이동
                }
            }
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}
