import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            dq.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            dq.addLast(dq.pollFirst());

            for (char ch : dq) {
                sb.append(ch);
            }

            if (isOk(sb.toString())) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isOk(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (s.isEmpty()) return false;

                if ((ch == ')' && s.peek() == '(') ||
                        (ch == '}' && s.peek() == '{') ||
                        (ch == ']' && s.peek() == '[')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        return s.isEmpty();
    }
}