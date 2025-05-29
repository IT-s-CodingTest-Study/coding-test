import java.util.*;

class 신고결과받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
		Set<String> reportSet = new HashSet<>(Arrays.asList(report));
		Map<String, Integer> reportCount = new HashMap<>();
		Map<String, Set<String>> reportUser = new HashMap<>();

		for(String str : reportSet) {
			String[] arr = str.split(" ");
			String from = arr[0];
			String to = arr[1];

			reportCount.put(to, reportCount.getOrDefault(to, 0) + 1);
			reportUser.computeIfAbsent(from, x -> new HashSet<>()).add(to);
		}

		Set<String> bannedUser = new HashSet<>();
		for(String user : reportCount.keySet()){
			if(reportCount.get(user) >= k) {
				bannedUser.add(user);
			}
		}

		int [] answer = new int[id_list.length];
		Map<String, Integer> idIndex = new HashMap<>();
		for(int i = 0; i < id_list.length; i++){
			idIndex.put(id_list[i], i);
		}

		for(String reporter : reportUser.keySet()) {
			for(String reported : reportUser.get(reporter)) {
				if(bannedUser.contains(reported)) {
					int idx = idIndex.get(reporter);
					answer[idx]++;
				}
			}
		}
		return answer;
	}
}