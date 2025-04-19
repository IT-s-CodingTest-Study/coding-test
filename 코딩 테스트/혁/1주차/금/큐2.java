import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 큐2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] part = br.readLine().split(" ");
            String command = part[0];

            switch (command) {
                case "push":
                    int value = Integer.parseInt(part[1]);
                    queue.offer(value);
                    break;
                case "front":
                    arr.add(queue.isEmpty() ? -1 : queue.peek());
                    break;
                case "back":
                    arr.add(queue.isEmpty() ? -1 : ((LinkedList<Integer>) queue).getLast());
                    break;
                case "size":
                    arr.add(queue.size());
                    break;
                case "empty":
                    arr.add(queue.isEmpty() ? 1 : 0);
                    break;
                case "pop":
                    arr.add(queue.isEmpty() ? -1 : queue.poll());
                    break;
            }
        }

        for (int result : arr) {
            bw.write(result + "\n");
        }
        bw.flush(); 
        bw.close();
    }
}
