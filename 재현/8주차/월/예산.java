import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for (int cost : d) {
            if (cost <= budget) {
                budget -= cost;
                answer++;
            }
            else break;
        }
        
        return answer;
    }
}