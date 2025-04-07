import java.io.*;
import java.util.*;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        // 덱 생성
        Deque<Integer> deque = new ArrayDeque<>();

        // 명령의 수 입력
        int N = Integer.parseInt(br.readLine());

        // N개의 명령 처리
        for (int i = 0; i < N; i++) {
            // 명령 한 줄 입력
            String commandLine = br.readLine();
            // 공백 기준으로 분리
            String[] parts = commandLine.split(" ");
            String command = parts[0]; // 명령어

            // 명령어에 따라 조건문 처리
            switch (command) {
                case "push_front":
                    // 앞쪽에 정수 삽입
                    int frontValue = Integer.parseInt(parts[1]);
                    deque.addFirst(frontValue);
                    break;

                case "push_back":
                    // 뒤쪽에 정수 삽입
                    int backValue = Integer.parseInt(parts[1]);
                    deque.addLast(backValue);
                    break;

                case "pop_front":
                    // 앞쪽 정수 제거 및 출력, 비어있으면 -1 출력
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.removeFirst()).append("\n");
                    }
                    break;

                case "pop_back":
                    // 뒤쪽 정수 제거 및 출력, 비어있으면 -1 출력
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.removeLast()).append("\n");
                    }
                    break;

                case "size":
                    // 덱의 현재 크기 출력
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    // 덱이 비어있으면 1, 아니면 0 출력
                    if (deque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    // 가장 앞에 있는 정수 출력, 없으면 -1 출력
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;

                case "back":
                    // 가장 뒤에 있는 정수 출력, 없으면 -1 출력
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
