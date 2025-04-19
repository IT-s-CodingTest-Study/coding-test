import java.io.*;
import java.util.*;

public class 큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>(); // back 처리를 위해 양방향 덱 사용

        int testCount = Integer.parseInt(br.readLine()); // 명령 개수 입력 받기

        for (int i = 0; i < testCount; i++) {
            String line = br.readLine(); // 한 줄 읽기
            String[] tokens = line.split(" "); // 공백 기준 명령어 분리 ("push 3" -> token[0] = "push" / token[1] = "3")
            String command = tokens[0]; // 명령어 추출 ("push", "pop", "size" 등)

            switch (command) {
                case "push":
                    int x = Integer.parseInt(tokens[1]);
                    deque.offer(x); // 뒤에 추가
                    break;

                case "pop":
                    // 큐가 비어있으면 -1, 아니면 앞에서 꺼내고 출력
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.poll()); // 큐 앞에서 꺼내서 삭제
                    }
                    sb.append("\n");
                    break;

                case "size":
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    if (deque.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;

                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peek());
                    }
                    sb.append("\n");
                    break;

                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peekLast()); // 뒤 값 삭제
                    }
                    sb.append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
