import java.io.*;
import java.util.Stack;

 public class 스택 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //시간초과 방지
            StringBuilder sb = new StringBuilder();  // 출력 저장용
            Stack<Integer> stack = new Stack<>();    // 스택

            int N = Integer.parseInt(br.readLine());  // 명령 개수 정의

            for (int i = 0; i < N; i++) {
                String command = br.readLine();       // 명령할 개수 입력

                if (command.startsWith("push")) {
                    int num = Integer.parseInt(command.split(" ")[1]);
                    stack.push(num);
                }
                 else if (command.equals("pop")) {
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n"); // 없으면 -1
                } 
                else if (command.equals("size")) {
                    sb.append(stack.size()).append("\n");
                } 
                else if (command.equals("empty")) {
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n"); // empty(true) = 1, not empty(false) = 0 출력
                } 
                else if (command.equals("top")) {
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n"); // 없으면 -1
                }
                
            }

            System.out.print(sb);  // 결과 출력

        } catch (IOException e) {
           
        }
    }
}
