import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        
        int count = 0;
        int camera = Integer.MIN_VALUE;
        
        for (int[] route: routes) {
            int enter = route[0];
            int exit = route[1];
            
            if (enter > camera) {
                count++;
                camera = exit;
            }
        }
        
        return count;
    }
}