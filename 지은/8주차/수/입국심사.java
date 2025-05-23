import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long minTime = 1;
        long maxTime = (long) times[times.length - 1] * n;
        long answer = maxTime;

        while (minTime <= maxTime) {
            long midTime = (minTime + maxTime) / 2;

            long totalPeople = 0;
            for (int time : times) {
                totalPeople += midTime / time;
            }

            if (totalPeople >= n) {
                answer = midTime;
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }

        return answer;
    }
}
