import java.util.*;
class 합승택시요금 {
	class Node implements Comparable<Node> {
		int to, cost;
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(Node node){
			return this.cost - node.cost;
		}
	}
	public int solution(int n, int s, int a, int b, int[][] fares) {
		// 그래프 인접리스트로 생성
		// 각 지점마다 연결 노드를 저장
		List<List<Node>> graph = new ArrayList<>();
		for(int i = 0; i <= n; i++){
			graph.add(new ArrayList<>());
		}

		//양방향 간선 추가
		for(int[] edge : fares){
			int from = edge[0];
			int to = edge[1];
			int cost = edge[2];
			graph.get(from).add(new Node(to, cost));
			graph.get(to).add(new Node(from, cost));
		}

		//다익스트라 알고리즘으로 각 지점에서의 최소 요금 거리 계산
		int[] distS = dijkstra(n, s, graph);
		int[] distA = dijkstra(n, a, graph);
		int[] distB = dijkstra(n, b, graph);

		//모든 지점을 종료 지점 후보로 고려
		//s -> i 까지는 합승, i -> a, i -> b는 각자 이동
		int answer = Integer.MAX_VALUE; //최소 요금 저장 변수
		for(int i = 1; i <= n; i++){
			//s -> i + i -> a + i -> b 의 총 요금
			int totalCost = distS[i] + distA[i] + distB[i];
			//최솟값 계산
			answer = Math.min(answer, totalCost);
		}

		return answer;
	}

	private int[] dijkstra(int n, int start, List<List<Node>> graph) {
		int[] dist = new int[n + 1]; //최단 거리 저장
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0; //시작점가지 거리

		//우선순위 큐를 활용하여 가중치가 작은 순서대로 꺼내옴
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));

		while(!q.isEmpty()) {
			Node cur = q.poll();
			//이미 더 짧은 경로로 방문을 했다면 해당 경로 무시
			if(dist[cur.to] < cur.cost) continue;

			//현재 노드에서 인접한 모든 노드를 탐색
			for(Node next : graph.get(cur.to)) {
				//현재까지 비용 + 다음 노드로 가는 비용이 더 작으면 해당 값으로 갱신
				if(dist[next.to] > cur.cost + next.cost) {
					dist[next.to] = cur.cost + next.cost;
					q.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}
}