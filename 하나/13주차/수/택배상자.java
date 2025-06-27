import java.util.*;

class Solution {
    public int solution(int[] order) {
        int count = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        int box = 1;
        int idx = 0;
        
        while(box <= order.length){
            if(order[idx] == box){
                count++;
                idx++;
                box++;
            }else if(!stack.isEmpty() && stack.peek() == order[idx]){
                stack.pop();
                count++;
                idx++;
            }else{
                stack.push(box);
                box++;
            }
        }
        while(!stack.isEmpty() && stack.peek() == order[idx]){
            stack.pop();
            count++;
            idx++;
        }
      
        return count;
    }
}
