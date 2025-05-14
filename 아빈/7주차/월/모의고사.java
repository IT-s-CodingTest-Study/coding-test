import java.util.*;
class Solution {
	public int[] solution(int[] answers) {
		int[] supo_1 = {1, 2, 3, 4, 5};
		int[] supo_2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] supo_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] correct = {0, 0, 0};
		for(int i = 0; i < answers.length; i++){
			if(supo_1[i % 5] == answers[i]) {
				correct[0]++;
			}
			if(supo_2[i % 8] == answers[i]) {
				correct[1]++;
			}
			if(supo_3[i % 10] == answers[i]){
				correct[2]++;
			}
		}
		int max = 0;
		for(int i : correct) {
			if(max < i){
				max = i;
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < correct.length; i++){
			if(correct[i] == max) {list.add(i + 1);}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}