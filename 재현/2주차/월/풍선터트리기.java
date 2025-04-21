import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class 풍선터트리기 {
    static int n;
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static Deque<int[]> d;
    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        d = new ArrayDeque<>();

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            d.add(new int[]{i + 1, Integer.parseInt(st.nextToken())});
        }

        while (!d.isEmpty()) {
            int[] cur = d.pollFirst();
            sb.append(cur[0]).append(" ");

            if(d.isEmpty()) break;

            if (cur[1] > 0) {
                for (int i = 0; i < cur[1] - 1; i++) {
                    d.addLast(d.pollFirst());
                }
            } else {
                for (int i = 0; i < -cur[1]; i++) {
                    d.addFirst(d.pollLast());
                }
            }
        }

        System.out.println(sb);
        br.close();

    }
}