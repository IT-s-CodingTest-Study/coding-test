import java.util.*;
class 입국심사 {
	public long solution(int n, int[] times) {
		long answer = 0;
		Arrays.sort(times);
		long max = times[times.length - 1] * (long)n;
		long min = 0;
		while(min <= max){
			long mid = (min + max) / 2;
			long people = 0;
			for(int t : times){
				people += mid / t;
			}
			if(people < n){
				min = mid + 1;
			} else {
				max = mid - 1;
				answer = mid;
			}
		}
		return answer;
	}
}