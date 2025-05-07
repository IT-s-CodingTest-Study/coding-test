import java.util.*;
class Solution {
	Map<String, Integer> str_list = new HashMap<>();
	List<String> result_list = new ArrayList<>();
	int[] course_list;

	public String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		this.course_list = course;
		for(String order : orders){
			char[] arr = order.toCharArray();
			Arrays.sort(arr);
			for(int length : course) {
				dfs(arr, 0, length, "", new boolean[arr.length]);
			}
		}

		for(int length : course) {
			int max = 0;
			for(Map.Entry<String, Integer> entry : str_list.entrySet()){
				if(entry.getKey().length() == length){
					max = Math.max(max, entry.getValue());
				}
			}

			for(Map.Entry<String, Integer> entry : str_list.entrySet()){
				if(entry.getKey().length() == length && entry.getValue() == max && max >= 2){
					result_list.add(entry.getKey());
				}
			}
		}
		Collections.sort(result_list);
		return result_list.toArray(new String[0]);
	}

	private void dfs(char[] order, int index, int length, String str, boolean[] visited) {
		if(str.length() == length){
			str_list.put(str, str_list.getOrDefault(str, 0) + 1);
			return;
		}
		for(int i = index; i < order.length; i++){
			dfs(order, i + 1, length, str + order[i], visited);
		}
	}
}