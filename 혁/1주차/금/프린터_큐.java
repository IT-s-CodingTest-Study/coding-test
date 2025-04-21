import java.util.*;
import java.io.*;

public class 프린터_큐{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String[] part = br.readLine().split(" ");
            int doc = Integer.parseInt(part[0]);
            int start = Integer.parseInt(part[1]);

            Queue<Document> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            String[] priorities = br.readLine().split(" ");
            for (int j = 0; j < doc; j++) {
                int priority = Integer.parseInt(priorities[j]);
                queue.add(new Document(j, priority));
                pq.add(priority);
            }

            int printOrder = 0;

            while (!queue.isEmpty()) {
                Document current = queue.poll();
                if (current.priority < pq.peek()) {
                    queue.add(current);
                } else {
                    printOrder++;
                    pq.poll();
                    if (current.index == start) {
                        sb.append(printOrder).append("\n");
                        break;
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}

