import java.io.*;

public class 스택수열 {

    private static int[] stack  = new int[100];
    private static int size =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n];

        for(int i =0; i<n; i++){
            sequence[i] = Integer.parseInt(br.readLine());
        }

        int number = 1;

        for(int i =0; i<n; i++){

            int target = sequence[i];

            while(number <= target){
                push(number++);
                sb.append("+\n");
            }

            if(peek() == target){
                pop();
                sb.append("-\n");
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
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
    static public int peek(){
        if(size==0)return -1;
        else{
            return stack[size-1];
        }
    }
}
