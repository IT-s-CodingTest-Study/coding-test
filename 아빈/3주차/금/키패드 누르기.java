import java.util.*;
class Solution {
	public String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
		int [] left_point = {0, 0};
		int [] right_point = {2, 0};

		Map<Integer, int[]> point = new HashMap<>();
		int[][] keypad = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9},
			{-1, 0, -2}
		};

		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 3; x++) {
				int number = keypad[y][x];
				if (number >= 0) {
					point.put(number, new int[]{x, 3 - y});
				}
			}
		}

		for(int i = 0; i < numbers.length; i++){
			if(numbers[i] % 3 == 1){
				answer.append("L");
				left_point = point.get(numbers[i]);
			} else if(numbers[i] % 3 == 0 && numbers[i] != 0){
				answer.append("R");
				right_point = point.get(numbers[i]);
			} else {
				int [] point_arr = point.get(numbers[i]);
				int left_distance = Math.abs(left_point[0] - point_arr[0]) + Math.abs(left_point[1] - point_arr[1]);
				int right_distance = Math.abs(right_point[0] - point_arr[0]) + Math.abs(right_point[1] - point_arr[1]);
				if(left_distance < right_distance){
					answer.append("L");
					left_point = point.get(numbers[i]);
				} else if(left_distance > right_distance) {
					answer.append("R");
					right_point = point.get(numbers[i]);
				} else {
					if (hand.equals("left")) {
						answer.append("L");
						left_point = point.get(numbers[i]);
					} else {
						answer.append("R");
						right_point = point.get(numbers[i]);
					}
				}
			}
		}

		return answer.toString();
	}
}