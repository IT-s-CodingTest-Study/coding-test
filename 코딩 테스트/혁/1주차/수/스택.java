import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<Integer> stackPrint = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            StringBuilder str = new StringBuilder(br.readLine());
            String [] arr = str.toString().split(" ");
            if(arr[0].equals("push")){
                stack.add(Integer.parseInt(arr[1]));
            }
            else if(arr[0].equals("pop")){
                if(!stack.isEmpty())
                    stackPrint.add(stack.remove(stack.size()-1));
                else
                    stackPrint.add(-1);
            }
            else if(arr[0].equals("empty")){
                if(!stack.isEmpty())
                    stackPrint.add(0);
                else
                    stackPrint.add(1);
            }
            else if(arr[0].equals("size")){
                stackPrint.add(stack.size());
            }
            else if(arr[0].equals("top")){
                if (stack.isEmpty())
                    stackPrint.add(-1);
                else
                    stackPrint.add(stack.get(stack.size()-1));
            }
        }
        for (int i = 0; i < stackPrint.size(); i++) {
            System.out.println(stackPrint.get(i));
        }
    }
}
