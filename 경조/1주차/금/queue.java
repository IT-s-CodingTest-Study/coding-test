import java.io.*;
import java.util.*;

public class queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String command = br.readLine();

            switch(command.split(" ")[0]) { // 공백 기준으로 나눔
                case "push":
                    int num = Integer.parseInt(command.split(" ")[1]);
                    queue.add(num);
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.remove()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(queue.isEmpty()? -1 : queue.peek()).append('\n');
                    break;
                case "back":
                    sb.append(queue.isEmpty()? -1 : queue.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
