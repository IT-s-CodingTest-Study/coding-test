import java.util.*;
class 괄호회전하기 {
	public int solution(String s) {
		int answer = 0;
		int x = s.length();

		Deque<Character> dq = new ArrayDeque<>();
		for(int i = 0; i < x; i++) {
			dq.addLast(s.charAt(i));
		}

		for(int i = 0; i < x; i++){
			if(correct(dq, x)) {
				answer++;
			}
			char a = dq.pollFirst();
			dq.addLast(a);
		}
		return answer;
	}

	private boolean correct(Deque<Character> dq, int x) {
		Stack<Character> stack = new Stack<>();
		Deque<Character> copy = new ArrayDeque<>(dq);

		for(int i = 0; i < x; i++) {
			char a = copy.pollFirst();
			if(a == '(' || a == '{' || a == '['){
				stack.push(a);
			} else {
				if(stack.isEmpty()) return false;
				char t = stack.pop();
				if(!isPair(t, a)) return false;
			}
		}
		return stack.isEmpty();
	}

	private boolean isPair(char a, char b) {
		return (a=='(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
	}
}