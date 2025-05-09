import java.util.*;
// class Solution {
// 	boolean[] visited;
// 	HashSet<String> id_list = new HashSet<>();
// 	public int solution(String[] user_id, String[] banned_id) {
// 		visited = new boolean[user_id.length];
//
// 		for(int i = 0; i < banned_id.length; i++){
// 			banned_id[i] = banned_id[i].replace('*', '.');
// 		}
//
// 		dfs(0, "", banned_id, user_id);
//
// 		return id_list.size();
//
// 	}
//
// 	private void dfs(int depth, String res, String[] banned_id, String[] user_id){
// 		if(depth == banned_id.length){
// 			String[] str_arr = res.split(" ");
// 			Arrays.sort(str_arr);
//
// 			String str = "";
// 			for(String s : str_arr) {
// 				str += s;
// 			}
//
// 			id_list.add(str);
//
// 			return;
// 		}
// 		for(int i = 0; i < user_id.length; i++){
// 			if(visited[i] || !user_id[i].matches(banned_id[depth])){
// 				continue;
// 			}
//
// 			visited[i] = true;
// 			dfs(depth + 1, user_id[i] + " " + res, banned_id, user_id);
// 			visited[i] = false;
// 		}
// 	}
// }

//개선된 코드
class 불량사용자 {
	Set<Set<String>> result = new HashSet<>();
	boolean[] visited;

	public int solution(String[] user_id, String[] banned_id) {
		visited = new boolean[user_id.length];
		dfs(0, new HashSet<>(), banned_id, user_id);
		return result.size();
	}

	private void dfs(int depth, Set<String> currentSet, String[] banned_id, String[] user_id) {
		if (depth == banned_id.length) {
			result.add(new HashSet<>(currentSet));
			return;
		}

		for (int i = 0; i < user_id.length; i++) {
			if (visited[i]) continue;

			if (user_id[i].length() != banned_id[depth].length()) continue;

			if (isMatch(user_id[i], banned_id[depth])) {
				visited[i] = true;
				currentSet.add(user_id[i]);
				dfs(depth + 1, currentSet, banned_id, user_id);
				currentSet.remove(user_id[i]);
				visited[i] = false;
			}
		}
	}

	private boolean isMatch(String user, String banned) {
		for (int i = 0; i < user.length(); i++) {
			if (banned.charAt(i) == '*') continue;
			if (user.charAt(i) != banned.charAt(i)) return false;
		}
		return true;
	}
}