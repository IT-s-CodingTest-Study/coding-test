import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);		// 바위 위치 오름차순으로 정렬
        
        int left = 0;
        int right = distance;
        
        // 이진 탐색
        while(left <= right) {
            int mid = (left + right) / 2;	// 현재 시도하는 최소 거리
            int removedRock = 0;			// 제거한 바위 개수
            int before = 0;					// 직전 바위(또는 시작점) 위치
            
            // 각 바위 거리가 mid 값보다 작으면 바위 제거
            for(int rock : rocks) {
                if(rock - before < mid) removedRock++;	// 최소 거리보다 작으면 바위 제거
                else before = rock;						// 현재 바위를 시작점으로 설정
            }
            
            // 마지막 바위에서 도착지점까지의 거리 확인
            if(distance - before < mid) removedRock++;
         	
            // 제거한 개수가 더 많다면 최소 거리(mid) 값을 줄임
            if(removedRock > n) right = mid - 1;
            else {
                answer = Math.max(answer, mid);
            	left = mid + 1;  
            }
        }
        return answer;
    }
}