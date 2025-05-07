import java.util.*;

class 여행경로 {
	boolean[] used; // 사용한 티켓
	ArrayList<String> allRoute;

	public String[] solution(String[][] tickets) {
		Map<String, List<Integer>> tickets_map = new HashMap<>();
		used = new boolean[tickets.length];
		allRoute = new ArrayList<>();

		//출발지별로 티켓 인덱스를 모은다
		for (int i = 0; i < tickets.length; i++) {
			String from = tickets[i][0];
			tickets_map.putIfAbsent(from, new ArrayList<>());
			tickets_map.get(from).add(i);
		}

		// 목적지 기준으로 정렬
		for (String key : tickets_map.keySet()) {
			tickets_map.get(key).sort((a, b) -> tickets[a][1].compareTo(tickets[b][1]));
		}

		// dfs 호출
		dfs(tickets_map, "ICN", "ICN", tickets, 0);

		return allRoute.get(0).split(" ");
	}

	public void dfs(Map<String, List<Integer>> tickets_map, String current, String route, String[][] tickets, int count) {
		if (count == tickets.length) {  //모든 티켓을 다 사용했다면
			allRoute.add(route);
			return;
		}

		if (!tickets_map.containsKey(current)) return;  // 현재 위치에서 출발할 수 있는 티켓이 없다면 종료

		for (int i : tickets_map.get(current)) {
			if (!used[i]) {
				used[i] = true;
				dfs(tickets_map, tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
				used[i] = false; // 다른 경로가 더 있는지 보기위해 사용하지 않은 상태로 복구
			}
		}
	}
}