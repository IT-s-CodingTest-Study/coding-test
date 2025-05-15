import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] student = new int[n + 2];
        Arrays.fill(student, 1);
        
        for (int i = 0; i < lost.length; i++) {
            student[lost[i]]--;
        }
        
        for (int i = 0; i < reserve.length; i++) {
            student[reserve[i]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (student[i] == 0) {
                if (student[i - 1] == 2) {
                    student[i]++;
                    student[i - 1]--;
                } else if (student[i + 1] == 2) {
                    student[i]++;
                    student[i + 1]--;
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (student[i] >= 1) {
                answer++;
            }
        }

        return answer;      
    }
}