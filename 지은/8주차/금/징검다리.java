import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 1; 
        int right = distance;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2; // 현재 시도 중인 최소 거리
            int removed = 0; // 제거한 돌 개수
            int prev = 0; // 이전 돌 위치

            // 돌 사이 거리 검사
            for (int rock : rocks) {
                if (rock - prev < mid) {
                    // 최소 거리보다 짧으면 돌 제거
                    removed++;
                } else {
                    // 최소 거리 이상이면 돌 유지
                    prev = rock;
                }
            }

            // 도착지점까지 거리 검사
            if (distance - prev < mid) removed++;

            if (removed <= n) {
                // 돌 제거 개수가 n 이하면 거리 늘려보기
                answer = mid;
                left = mid + 1;
            } else {
                // n 초과면 거리 줄이기
                right = mid - 1;
            }
        }

        return answer;
    }
}
