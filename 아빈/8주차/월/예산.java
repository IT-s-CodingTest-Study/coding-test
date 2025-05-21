import java.util.*;
class  예산 {
	public int solution(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);
		for(int a : d) {
			if(a > budget){
				break;
			}
			budget -= a;
			answer++;
		}
		return answer;
	}
}