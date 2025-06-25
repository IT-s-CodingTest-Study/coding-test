import java.util.*;
public class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        // 보조 컨테이너 벨트
        Deque<Integer> stack = new ArrayDeque<>();

        int idx = 0;
        for(int i = 1; i <= order.length; i++) {
            stack.push(i);

            while(!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            }
        }

        return answer;
    }
}