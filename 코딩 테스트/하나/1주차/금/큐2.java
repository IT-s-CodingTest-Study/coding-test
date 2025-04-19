import java.io.*;
import java.util.StringTokenizer;

public class 큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Queue queue = new Queue(n);

        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch(s){
                case "push": queue.push(Integer.parseInt(st.nextToken())); break;
                case "pop" : sb.append(queue.pop()).append("\n"); break;
                case "size" : sb.append(queue.size()).append("\n"); break;
                case "empty" : sb.append(queue.empty()).append("\n"); break;
                case "front": sb.append(queue.front()).append("\n");break;
                case "back": sb.append(queue.back()).append("\n"); break;

            }
        } System.out.print(sb);

    }
}
class Queue{
    private int[] que;
    private int size;
    private int front; //앞
    private int rear; //끝

    //생성자
    public Queue(int capacity){
        que = new int[capacity];
        size = front = rear = 0;
    }

    public void push(int n){
        que[rear++]=n;
        size++;
    }
    public int pop(){
      if (empty()==1)return -1;
      size--;
      return que[front++];
    }
    public int size(){
        return size;
    }
    public int empty(){
        return size==0 ? 1:0;
    }
    public int front(){
        if (empty()==1)return -1;
        return que[front];
    }
    public int back(){
        if (empty()==1)return -1;
        return que[rear-1];
    }
}
