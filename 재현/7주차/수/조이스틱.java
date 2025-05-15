import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < name.length(); i++) {
            answer += calc(name.charAt(i));
        }
        
        int move = length - 1;
        
        for (int i = 0; i < length; i++) {
            if (name.charAt(i) == 'A') {
                int start_idx = i;

                while (i < length && name.charAt(i) == 'A') {
                    i++;
                }

                int end_idx = i;
                
                int forwardCost = start_idx == 0 ? length - end_idx : ((start_idx - 1) * 2 + (length - end_idx));
                int backwardCost = (length - end_idx) * 2 + ((start_idx - 1 < 0) ? 0 : (start_idx - 1));

                move = Math.min(move, Math.min(forwardCost, backwardCost));
            }
        }

        return answer + move;
    }
    
    static int calc(char c) {
        return Math.min(c - 'A', 'Z' - c + 1);
    }
}