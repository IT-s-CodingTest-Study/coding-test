import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int box = 1;
        
        while(box <= order.length) {
            if(order[idx] == box) {
                idx++;
                box++;
            } else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
            } else {
                stack.push(box);
                box++;
            }
        }
        
        while (!stack.isEmpty() && stack.peek() == order[idx]) {
            stack.pop();
            idx++;
        }
        
        return idx;
    }
}