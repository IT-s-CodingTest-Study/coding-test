import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; 
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean[] visited = new boolean[reserve.length]; // 여벌 사용 여부

        // 자기 여벌로 해결
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] && !visited[j]) {
                    visited[j] = true;
                    lost[i] = -1;
                    answer++;
                    break;
                }
            }
        }

        // 인접 학생에게 빌림
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) continue;

            for (int j = 0; j < reserve.length; j++) {
                if (!visited[j] &&
                   (reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1)) {
                    visited[j] = true;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
