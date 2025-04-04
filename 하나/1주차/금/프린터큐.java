import java.io.*;
import java.util.*;

public class 프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서 개수
            int m = Integer.parseInt(st.nextToken()); // 궁금한 문서 위치

            LinkedList<Node> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            //문서 목록을 queue에 저장
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Node(i, priority));
            }

            int order = 0;
            while (!queue.isEmpty()) {
                //가장 앞에 있는 문서를 꺼냄
                Node current = queue.poll();

                boolean higherPriority = false;
                for (Node node : queue) {
                    if (node.priority > current.priority) {
                        higherPriority = true;
                        break;
                    }
                }

                //남은 queue에 더 높은 중요도가 있다면 재배치
                if (higherPriority) {
                    queue.offer(current);
                } else {
                    order++;
                    if (current.index == m) {
                        sb.append(order).append("\n"); //목표 문서라면 출력
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }

    static class Node {
        int index;
        int priority;

        Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
