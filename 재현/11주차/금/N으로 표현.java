import java.util.*;

class Solution {
    
    public int solution(int N, int number) {
        List<Set<Integer>> dp  = new ArrayList<>();
        dp.add(new HashSet<>());
        
        for (int i = 1; i <= 8; i++) {
            Set<Integer> set = new HashSet<>();
            
            // RN : N이 i번 사용된 숫자
            int RN = Integer.parseInt(String.valueOf(N).repeat(i));
            set.add(RN);
            
            for (int j = 1; j < i; j++) {
                // N이 j번 사용된 숫자
                Set<Integer> set1 = dp.get(j);
                // N이 i-j번 사용된 숫자
                Set<Integer> set2 = dp.get(i - j);
                
                for (int a : set1) {
                    for (int b : set2) {
                        set.add(a + b);
                        set.add(a - b);
                        set.add(a * b);
                        if (b != 0)
                            set.add(a / b);
                    }
                }
            }
            
            if (set.contains(number)) {
                return i;
            }
            
            dp.add(set);
        }
        return -1;
    }
}