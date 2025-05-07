class Solution {
	int answer = 0;

	public int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);
		return answer;
	}

	private void dfs(int[] numbers, int target, int depth, int sum) {
		if(depth == numbers.length){    //배열 끝까지 갔다면
			if(sum == target){          //target과 요소들의 합이 갔다면
				answer++;               //경우의 수 증가
			}
			return;
		}
		dfs(numbers, target, depth + 1, sum + numbers[depth]);      // 더한 경우
		dfs(numbers, target, depth + 1, sum - numbers[depth]);      // 뺀 경우
	}
}