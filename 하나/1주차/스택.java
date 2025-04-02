import java.io.*;
import java.util.StringTokenizer;

public class 스택 {
    static int [] stack = new int[10000];
    static int size=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch (s) {
                case "push": push(Integer.parseInt(st.nextToken()));break;
                case "pop" : sb.append(pop()).append("\n");break;
                case "size" : sb.append(size()).append("\n"); break;
                case "empty" : sb.append(empty()).append("\n"); break;
                case "top" : sb.append(top()).append("\n"); break;
            }
        } System.out.print(sb);

    }
    static public void push(int n){
        stack[size]=n;
        size++;
    }
    static public int pop(){
        if (size==0) return -1;
        else{
            int p = stack[size-1];
            size--;
            return p;
        }
    }
    static public int size(){
        return size;
    }
    static public int empty(){
        if(size==0) return 1;
        else return 0;
    }
    static public int top(){
        if(size==0) return -1;
        else{
            return stack[size-1];
        }
    }
}
