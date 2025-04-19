import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class 문자열_집합 {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m, count;
    static Set<String> set;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        count = 0;
        for (int i = 0; i < m; i++) {
            if (set.contains(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}