import java.util.*;
public class stack_sequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 초기 입력 값
        int num = in.nextInt();
        // 수열
        int[] arr = new int[num];

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<num; i++){
            arr[i] = in.nextInt();
        }
        
        int index=0;
        // stack_max 스택에 push한 값 계산하기 위함
        int stack_max = 1;

        while(index < num){
            if(!stack.empty() && arr[index] < stack.peek()) {
                break;
            }
            else if(!stack.empty() && arr[index] == stack.peek()) {
                stack.pop();
                sb.append("-\n");
                index++;
            }
            // 스택이 비어있거나, 있어도 스택 맨 위의 값이 arr[index] 보다 작은 경우
            else {
                while(stack_max <= num){
                    if(arr[index] != stack_max) {
                        stack.push(stack_max);
                        sb.append("+\n");
                        stack_max++;
                    }
                    else {
                        stack.push(stack_max);
                        sb.append("+\n");
                        stack_max++;
                        break;
                    }
                }
            }
        }


        if(index == num) {
            System.out.println(sb);
        }
        else {
            System.out.println("NO");
        }
    }
}
