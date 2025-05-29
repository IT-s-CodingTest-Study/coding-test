import java.util.*;

class 보물지도 {
	class State{
		int r;
		int c;
		int dist;
		int jumped;
		State(int r, int c, int dist, int jumped){
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.jumped = jumped;
		}
	}
	public int solution(int n, int m, int[][] hole) {
		// BFS 최단거리 구하기
		// 시작점 예약 (0,0, dist, jumped)
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		int[] dr2 = {2, -2, 0, 0,};
		int[] dc2 = {0, 0, 2, -2};

		Queue<State> queue = new ArrayDeque<>();
		int[][] maps = new int[n][m];
		for(int[] h: hole){
			maps[h[0]-1][h[1]-1] = 1;
		}
		boolean[][][] visited = new boolean[n][m][2];
		queue.offer(new State(0, 0, 0, 0));
		visited[0][0][0] = true;

		while(!queue.isEmpty()){
			// 현재 노드 방문
			State cur = queue.poll();
			// if 도착지 방문: return dist;
			if(cur.r == n-1 && cur.c == m-1) return cur.dist;

			// 다음 노드 방문
			for(int i = 0; i < 4; i++){
				int nr = cur.r + dr[i], nc = cur.c + dc[i];
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 0){
					if(!visited[nr][nc][cur.jumped]){
						queue.offer(new State(nr, nc, cur.dist+1, cur.jumped));
						visited[nr][nc][cur.jumped] = true;
					}
				}
			}
			if(cur.jumped == 0){
				for(int i = 0; i < 4; i++){
					int nr = cur.r + dr2[i], nc = cur.c + dc2[i];
					if(nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 0){
						if(!visited[nr][nc][cur.jumped+1]){
							queue.offer(new State(nr, nc, cur.dist+1, cur.jumped+1));
							visited[nr][nc][cur.jumped+1] = true;
						}
					}
				}
			}
		}
		return -1;
	}
}