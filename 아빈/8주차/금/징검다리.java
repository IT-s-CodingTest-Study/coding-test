import java.util.*;
class Solution {
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;
		int min = 0;
		int max = distance;
		Arrays.sort(rocks);
		while(min <= max) {
			int mid = (min + max) / 2;
			int remove = 0;
			int prev = 0;

			for(int i = 0; i < rocks.length; i++) {
				if(rocks[i] - prev < mid) {
					remove++;
				} else {
					prev = rocks[i];
				}
			}
			if(distance - prev < mid) remove++;

			if(remove <= n) {
				answer = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		return answer;
	}
}