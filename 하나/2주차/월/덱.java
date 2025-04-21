
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Dequeue deque = new Dequeue(n);

        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s){
                case "push_front": deque.push_front(Integer.parseInt(st.nextToken()));break;
                case "push_back":deque.push_back(Integer.parseInt(st.nextToken()));break;
                case "pop_front": sb.append(deque.pop_front()).append("\n");break;
                case "pop_back" :sb.append(deque.pop_back()).append("\n");break;
                case "size": sb.append(deque.size()).append("\n");break;
                case "empty" : sb.append(deque.empty()).append("\n");break;
                case "front": sb.append(deque.front()).append("\n");break;
                case "back": sb.append(deque.back()).append("\n");break;
            }
        }System.out.print(sb);
    }
}

class Dequeue {
    private int[] que;
    private int size;
    private int front; //앞
    private int rear; //끝

    public Dequeue(int capacity) {
        que= new int[capacity];
        size = capacity*2;
        front = rear = capacity/2;
    }

    public void push_front(int n) {
        que[--front] = n;
    }
    public void push_back(int n) {
        que[rear++] = n;
    }

    public int pop_front() {
        if (empty() == 1) return -1;
        return que[front++];
    }

    public int pop_back() {
        if (empty() == 1) return -1;
        return que[--rear];
    }

    public int size() {
        return rear-front;
    }

    public int empty() {
        return front==rear ? 1 : 0;
    }

    public int front() {
        if (empty() == 1) return -1;
        return que[front];
    }

    public int back() {
        if (empty() == 1) return -1;
        return que[rear - 1];
    }
}
