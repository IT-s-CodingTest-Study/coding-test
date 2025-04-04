import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.*;

class 프린터_큐 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int tc, n, m;
    static Integer[] priority;
    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            priority = new Integer[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                priority[i] = Integer.parseInt(st.nextToken());
                q.add(new int[]{i, priority[i]});
            }

            Arrays.sort(priority, Collections.reverseOrder());

            int count = 0;
            int priorityIdx = 0;
            while (!q.isEmpty()) {

                if (q.peek()[1] == priority[priorityIdx]) {
                    count++;
                    priorityIdx++;
                    if (q.peek()[0] == m) {
                        sb.append(count).append('\n');
                        break;
                    } else {
                        q.poll();
                    }
                } else {
                    q.add(q.poll());
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}