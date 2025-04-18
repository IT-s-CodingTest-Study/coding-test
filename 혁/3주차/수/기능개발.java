package 수;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            days[i] = (remain + speeds[i] - 1) / speeds[i];
        }

        List<Integer> result = new ArrayList<>();
        int maxDay = days[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (days[i] <= maxDay) {
                count++;
            } else {
                result.add(count);
                count = 1;
                maxDay = days[i];
            }
        }
        result.add(count);

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
