import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선_터뜨리기 {
    static class Balloon {
        int index;
        int move;

        Balloon(int index, int move) {
            this.index = index;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Balloon> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int move = Integer.parseInt(st.nextToken());
            deque.add(new Balloon(i, move));
        }

        StringBuilder sb = new StringBuilder();

        Balloon current = deque.pollFirst();
        sb.append(current.index).append(" ");

        while (!deque.isEmpty()) {
            int steps = current.move;

            if (steps > 0) {
                for (int i = 0; i < steps - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
                current = deque.pollFirst();
            }
            else {
                for (int i = 0; i < Math.abs(steps); i++) {
                    deque.addFirst(deque.pollLast());
                }
                current = deque.pollFirst();
            }

            sb.append(current.index).append(" ");
        }

        System.out.println(sb);
    }
}