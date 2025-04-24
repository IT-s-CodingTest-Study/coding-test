import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        // 남은 작업 일 계산
        int[] day = new int[progresses.length];
        for(int i = 0; i<progresses.length; i++) {
            int remain = 100 - progresses[i];
            day[i] = (remain % speeds[i] == 0) ? (remain / speeds[i]) : (remain / speeds[i] + 1);
        }
        List<Integer> result = new ArrayList<>();
        int currentMax = day[0];
        int count = 1;
        for(int i = 1; i < day.length; i++) {
            if(day[i] <= currentMax) {
                count++;
            }
            else {
                result.add(count);
                currentMax = day[i];
                count = 1;
            }
        }
        result.add(count);
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
