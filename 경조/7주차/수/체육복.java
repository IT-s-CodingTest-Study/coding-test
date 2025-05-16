import java.util.*;
public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            map.put(i, 1);
        }
        for(int lost_std : lost) {
            map.put(lost_std, map.getOrDefault(lost_std, 0) - 1);
        }

        for(int reserve_std : reserve) {
            map.put(reserve_std, map.getOrDefault(reserve_std, 0) + 1);
        }

        for(int i = 1; i <= n; i++) {
            if(map.get(i)==0) {
                if(i > 1 && map.get(i-1)==2) {
                    map.put(i - 1, 1);
                    map.put(i, 1);
                } else if(i < n && map.get(i+1)==2) {
                    map.put(i, 1);
                    map.put(i+1, 1);
                }
            }
        }

        for(Integer key : map.keySet()) {
            if(map.get(key) >= 1) answer++;
        }

        return answer;
    }
}