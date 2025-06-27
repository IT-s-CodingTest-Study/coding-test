import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>(); 
        int answer = 0; 
        int targetBox = 0; // 현재 실어야 할 order 인덱스

        for ( int box = 1; box <= order.length; box++) {
           // 현재 벨트에서 나오는 상자가 지금 실어야 할 상자와 같다면
            if (order[targetBox] == box) {
                answer++; // 실은 개수 증가
                targetBox++; // 다음에 실어야 할 상자로 이동
            } else {
                // 아니라면 보조 컨테이너 보관
                stack.push(box);
            }

            while (!stack.isEmpty() && stack.peek() == order[targetBox]) {
                stack.pop();
                answer++;
                targetBox++;
            }
        }

        return answer;
    }
}
