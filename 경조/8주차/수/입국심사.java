import java.util.*;
public class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;

        long start = 0;
        // 최대로 걸리는 시간
        long end = (long) times[times.length-1] * n;

        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            // 해당 시간(mid 값) 동안 심사한 인원 sum에 저장
            for(int time : times) {
                sum += mid / time;
            }

            // 만약 심사를 다한 경우
            if(sum >= n) {
                answer = mid;
                end = mid - 1;
            }
            // 심사를 다 못 한 경우
            else start = mid + 1;

        }

        return answer;
    }
}