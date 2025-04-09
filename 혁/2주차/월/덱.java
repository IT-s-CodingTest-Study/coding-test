package 월;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 덱 {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Deque<Integer> deque = new ArrayDeque<Integer>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] part = br.readLine().split(" ");
            String str = part[0];
            switch (str) {
                case "push_back": {
                    int num = Integer.parseInt(part[1]);
                    deque.addLast(num);
                    break;
                }
                case "push_front": {
                    int num = Integer.parseInt(part[1]);
                    deque.addFirst(num);
                    break;
                }
                case "pop_front": {
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    } else sb.append(deque.removeFirst()).append("\n");
                    break;
                }
                case "pop_back": {
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    } else sb.append(deque.removeLast()).append("\n");
                    break;
                }
                case "size": {
                    sb.append(deque.size()).append("\n");
                    break;
                }
                case "empty": {
                    if (deque.isEmpty()) {
                        sb.append(1).append("\n");
                        break;
                    } else sb.append(0).append("\n");
                    break;
                }
                case "front": {
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    } else sb.append(deque.peekFirst()).append("\n");
                    break;
                }
                case "back": {
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    } else sb.append(deque.peekLast()).append("\n");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
