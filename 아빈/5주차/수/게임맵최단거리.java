import java.util.*;
class Node {
	int x;
	int y;
	int distance;

	Node(int x, int y, int distance){
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}

class 게임맵최단거리 {
	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		//방문 여부
		boolean [][] visited = new boolean[n][m];
		Queue<Node> queue = new LinkedList<>();
		visited[0][0] = true; // 시작지점
		queue.add(new Node(0, 0, 1));
		int[] dy = {-1, 0, 1, 0};  // 상하좌우
		int[] dx = {0, 1, 0, -1};
		while(!queue.isEmpty()){
			Node now = queue.poll();

			if(now.x == n - 1 && now.y == m - 1){
				return now.distance;
			}

			for(int i = 0; i < 4; i++){
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < n && ny < m){
					if(!visited[nx][ny] && maps[nx][ny] == 1){
						visited[nx][ny] = true;
						queue.add(new Node(nx, ny, now.distance + 1));
					}
				}
			}
		}
		return -1;
	}
}