import java.util.*;
class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> answer = new LinkedList<>();
		Queue<Integer> q = new LinkedList<>();


		for(int i = 0; i < progresses.length; i++){
			int remain = 100 - progresses[i];
			int date = remain % speeds[i] == 0 ? remain / speeds[i] : remain / speeds[i] + 1;
			q.add(date);
		}

		while (!q.isEmpty()) {
			int date = q.poll();
			int count = 1;

			while (!q.isEmpty() && date >= q.peek()) {
				q.poll();
				count++;
			}

			answer.add(count);
		}

		int[] result = new int[answer.size()];
		int i = 0;
		while (!answer.isEmpty()) {
			result[i] = answer.poll();
			i++;
		}
		return result;
	}
}