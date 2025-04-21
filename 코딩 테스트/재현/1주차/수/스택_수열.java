import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_수열 {
    static int n, num, next;
    static Stack<Integer> stack;
    static StringBuilder sb;
    static BufferedReader br;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        stack = new Stack<>();

        n = Integer.parseInt(br.readLine());
        next = 1;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());

            while (next <= num) {
                stack.push(next++);
                sb.append('+').append('\n');
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append('-').append('\n');
            } else {
                System.out.println("NO");
                return;
            }

        }

        System.out.println(sb);
        br.close();
    }
}