import java.util.*;

public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int[] answers = new int[rocks.length];

        Arrays.sort(rocks);

        int left = 1;
        int right = distance;

        // 각 바위 사이 거리의 최솟값 후보 구하기
        // -> 이분탐색
        while(left <= right) {
            int mid = (left + right) / 2;
            int cur = 0; // 현재 바위
            int removeCount = 0;    // 제거한 바위 개수

            // 각 바위 거리까지가 mid보다 작으면 바위 제거
            for(int rock : rocks) {
                if(rock - cur < mid) removeCount++;
                else cur = rock;
            }

            // 도착점까지의 거리도 mid보다 작으면 제거
            if(distance - cur < mid) removeCount++;

            // 제거 개수 초과되면 범위 줄이기
            if(removeCount > n) {
                right = mid - 1;
            } else { // mid 거리로도 조건 만족하니까 저장하고 거리 넓힘
                answer = mid;
                left = mid + 1;
            }
        }

        return answer;
    }
}