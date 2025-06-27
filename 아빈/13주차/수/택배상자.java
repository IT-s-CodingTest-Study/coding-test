import java.util.*;
class 택배상자 {
	public int solution(int[] order) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		int bnu기m = 1;
		while(bnum <= order.length) {
			stack.push(bnum);

			while(!stack.isEmpty() && stack.peek() == order[idx]) {
				stack.pop();
				answer++;
				idx++;
			}
			bnum++;
		}
		return answer;
	}
}