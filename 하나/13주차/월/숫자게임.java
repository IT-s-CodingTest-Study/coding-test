import java.lang.Math;
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int cnt = 0;
        
        for(int i : B){
           if(A[cnt] >= i) continue;
            cnt++;
        }
        return cnt;
    }
}
