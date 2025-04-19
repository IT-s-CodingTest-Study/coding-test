import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스택 {
    static BufferedReader br;
    static StringTokenizer st;
    static int tc, num;
    static String cmd;
    static Stack s;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());
        s = new Stack();

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    s.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(s.pop()).append('\n');
                    break;
                case "size":
                    sb.append(s.size()).append('\n');
                    break;
                case "empty":
                    sb.append(s.empty() ? '1' : '0').append('\n');
                    break;
                case "top":
                    sb.append(s.top()).append('\n');
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
        br.close();

    }
}

class Stack {
    int top;
    int[] list;

    Stack() {
        this.top = -1;
        this.list = new int[10001];
    }

    void push(int data) {
        list[++top] = data;
    }
    
    int pop() {
        return this.empty() ? -1 : list[top--];
    }

    int size() {
        return this.top + 1;
    }

    boolean empty() {
        return this.top == -1;
    }

    int top() {
        return this.empty() ? -1 : list[top];
    }
}