package 월;

import java.util.*;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int a : d) {
            if(budget >= a){
                budget -= a;
                answer++;
            }
        }
        return answer;
    }
}
