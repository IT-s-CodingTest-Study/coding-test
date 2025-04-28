import java.util.*;
public class 타켓넘버 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        // index, sum은 0부터 시작
        dfs(numbers, 0, 0, target);
        return answer;
    }
    public void dfs(int[] numbers, int index, int sum, int target) {
        if(index == numbers.length) {	// index가 numbers.length와 같다면
            if(sum == target) {			// 현재 sum 과 target이 같으면 answer 증가
                answer++;
            }
            // numbers 요소를 다 사용했는데 안 나온 것이므로 return
            return;
        }
        // index 값 증가, 현재 sum 에서 numbers[index] 더해준 값을 넘김
        dfs(numbers, index + 1, sum + numbers[index], target);
        // index 값 증가, 현재 sum 에서 numbers[index] 빼준 값을 넘김
        dfs(numbers, index + 1, sum - numbers[index], target);
    }
}