import java.io.*;
import java.util.Stack;

public class 스택수열 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder(); //출력 저장용
            Stack<Integer> stack = new Stack<>();

            int N = Integer.parseInt(br.readLine()); // 수열 길이
            int nextPush = 1; // push할 다음 숫자 (1부터 N까지 순서대로)

            boolean possible = true; //수열 생성이 가능한지 ( +, - / "NO" )

            for (int i = 0; i < N; i++) {
                int target = Integer.parseInt(br.readLine()); // 만들고 싶은 수열의 요소를 target으로

                // (push할 숫자 <= target) -> push "+" 출력
                while (nextPush <= target) {
                    stack.push(nextPush++);
                    sb.append("+\n");
                }

                // (peek == target) -> pop "-" 출력
                if (stack.peek() == target) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    // 수열 생성 불가능한 경우
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.print(sb);
            } else {
                System.out.println("NO");
            }

        } catch (IOException e) {
    
        }
    }
}
