import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 덱 {
    static int input;
    static String cmd;
    static Deque d;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        d = new Deque();

        input = Integer.parseInt(br.readLine());

        for (int i = 0; i < input; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            switch (cmd) {
                case "push_front":
                    d.push_front(Integer.parseInt(st.nextToken())); break;
                case "push_back":
                    d.push_back(Integer.parseInt(st.nextToken())); break;
                case "pop_front":
                    sb.append(d.pop_front()).append("\n"); break;
                case "pop_back":
                    sb.append(d.pop_back()).append("\n"); break;
                case "size":
                    sb.append(d.size()).append("\n"); break;
                case "empty":
                    sb.append(d.empty() ? 1 : 0).append("\n"); break;
                case "front":
                    sb.append(d.front()).append("\n"); break;
                case "back":
                    sb.append(d.back()).append("\n"); break;

            }
        }

        System.out.println(sb);
        br.close();
    }
}


class Deque {
    static final int MAX_SIZE = 20001;
    int[] list;
    int front;
    int rear;

    Deque () {
        list = new int[MAX_SIZE];
        front = rear = MAX_SIZE / 2;
    }

    void push_front(int data) {
        list[--front] = data;
    }

    void push_back(int data) {
        list[rear++] = data;
    }

    int pop_front() {
        return empty() ? -1 : list[front++];
    }

    int pop_back() {
        return empty() ? -1 : list[--rear];
    }

    int size() {
        return rear - front;
    }

    boolean empty() {
        return front == rear;
    }

    int front() {
        return empty() ? -1 : list[front];
    }

    int back() {
        return empty() ? -1 : list[rear - 1];
    }
}
