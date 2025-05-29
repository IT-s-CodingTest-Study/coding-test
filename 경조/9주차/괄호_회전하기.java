import java.util.*;
public class 괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> queue = new ArrayDeque<>();

        // 괄호 정보 큐에 저장
        for(char c : s.toCharArray()) {
            queue.offer(c);
        }

        // 회전하면서 맞는지 체크
        for(int i = 0; i < s.length(); i++) {
            // 괄호 맞는지 체크
            if(check(new ArrayDeque<>(queue))) answer++;

            // 왼쪽으로 회전
            queue.offer(queue.poll());
        }

        return answer;
    }

    public boolean check(Deque<Character> q) {
        Deque<Character> stack = new ArrayDeque<>();

        while(!q.isEmpty()) {
            char c = q.poll();
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
