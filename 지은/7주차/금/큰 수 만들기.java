import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char c : number.toCharArray()) {
            // 현재 숫자 c보다 작고, 제거 횟수 남아있으면 제거
            while (k > 0 && !stack.isEmpty() && stack.peekLast() < c) {
                stack.pollLast();
                k--;
            }
            stack.addLast(c); // 추가
        }

        // 아직 제거 안되었으면 뒤에서 제거
        while (k-- > 0) {
            stack.pollLast();
        }
        
        // 스택에 남은 문자들 문자열에 추가
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
