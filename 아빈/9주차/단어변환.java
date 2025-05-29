import java.util.*;
class 단어변환 {
	public int solution(String s) {
		int answer = 0;
		int x = s.length();
		Deque<Character> q = new ArrayDeque<>();
		for(int i = 0; i < x; i ++){
			q.addLast(s.charAt(i));
		}
		for(int i = 0; i < x; i++) {
			if(correct(q, x)) {
				answer++;
			}
			char a = q.pollFirst();
			q.addLast(a);
		}
		return answer;
	}

	boolean correct(Deque<Character> q, int x) {
		Stack<Character> stack = new Stack<>();
		Deque<Character> copy = new ArrayDeque<>(q);
		for (int i = 0; i < x; i++) {
			char a = copy.pollFirst();
			if (a == '(' || a == '{' || a == '[') {
				stack.push(a);
			} else {
				if (stack.isEmpty()) return false;
				char t = stack.pop();
				if (!isPair(t, a)) return false;
			}
		}
		return stack.isEmpty();
	}
	boolean isPair(char a, char b) {
		return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
	}
}