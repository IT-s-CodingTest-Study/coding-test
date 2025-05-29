import java.util.*;

public class 괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = q.poll();
            q.offer(c);

            //검증
            Stack<Character> stack = new Stack<>();
            boolean isVaild = true;
            for(char c2 : q){
                if(c2 == '(' || c2 == '{' || c2 == '['){
                    stack.push(c2);
                }else {
                    if(stack.isEmpty()){
                        isVaild = false;
                        break;
                    }else {
                        char top = stack.peek();
                        if(top == '(' && c2 == ')' || top == '{' && c2 == '}' || top == '[' || c2 == ']'){
                            stack.pop();
                        }else{
                            isVaild = true;
                            break;
                        }
                    }
                }
            }
            if (!stack.isEmpty()) isVaild = false;
            if (isVaild) answer++;
        }
        return 0;
    }
}