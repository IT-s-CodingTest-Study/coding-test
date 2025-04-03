import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 큐2 {
    static int tc;
    static String cmd;
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static Queue q;
    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        q = new Queue();

        tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    q.push(Integer.parseInt(st.nextToken())); break;
                case "pop":
                    sb.append(q.pop()).append('\n'); break;
                case "size":
                    sb.append(q.size()).append('\n'); break;
                case "empty":
                    sb.append(q.empty() ? 1 : 0).append('\n'); break;
                case "front":
                    sb.append(q.front()).append('\n'); break;
                case "back":
                    sb.append(q.back()).append('\n'); break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}

class Queue {
    int frontIdx;
    int backIdx;
    int[] list;

    Queue() {
        this.frontIdx = 0;
        this.backIdx = 0;
        this.list = new int[2000001];
    }

    void push(int data) {
        list[backIdx++] = data;
    }

    int pop() {
        return empty() ? -1 : list[frontIdx++];
    }

    int size() {
        return backIdx - frontIdx;
    }

    boolean empty() {
        return backIdx == frontIdx;
    }

    int front() {
        return empty() ? -1 : list[frontIdx];
    }

    int back() {
        return empty() ? -1 : list[backIdx - 1];
    }


}