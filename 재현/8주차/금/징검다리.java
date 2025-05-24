import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (removeRocks(rocks, distance, mid) <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public int removeRocks(int[] rocks, int distance, int mid) {
        int before = 0;
        int remove = 0;
        int end = distance;
        
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - before < mid) {
                remove++;
                continue;
            }
            before = rocks[i];
        }
        
        if (end - before < mid) 
            remove++;
        
        return remove;
    }
}
