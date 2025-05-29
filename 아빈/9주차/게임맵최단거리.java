import java.util.*;
import java.util.*;
class 게임맵최단거리 {
	class Node {
		int x;
		int y;
		int distance;

		Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	public int solution(int[][] maps) {
		Queue<Node> q = new LinkedList<>();
		int n = maps.length;
		int m = maps[0].length;

		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		q.add(new Node(0, 0, 1));

		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};

		while(!q.isEmpty()) {
			Node curr = q.poll();

			if(curr.x == n - 1 && curr.y == m - 1) {
				return curr.distance;
			}

			for(int i = 0; i < 4; i++){
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < n && ny < m){
					if(!visited[nx][ny] && maps[nx][ny] == 1) {
						visited[nx][ny] = true;
						q.add(new Node(nx, ny, curr.distance + 1));
					}
				}
			}
		}
		return -1;
	}
}