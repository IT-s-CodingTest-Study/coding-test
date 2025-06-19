import java.util.*;
class 경주로건설라 {
	class Node{
		int x;
		int y;
		int dir;
		int cost;

		Node(int x, int y, int dir, int cost){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}
	}
	public int solution(int[][] board) {
		int n = board.length;

		Queue<Node> q = new LinkedList<>();
		int [][][] visited = new int [n][n][4];

		for (int[][] arr1 : visited){
			for(int [] arr2 : arr1) {
				Arrays.fill(arr2, Integer.MAX_VALUE);
			}
		}

		q.add(new Node(0, 0, 1, 0));   // 오른쪽 방향 차
		q.add(new Node(0, 0, 2, 0));   // 아래쪽 방향 차
		visited[0][0][1] = 0;
		visited[0][0][2] = 0;

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		while(!q.isEmpty()) {
			Node curr = q.poll();

			for(int i = 0; i < 4; i++){
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				int nCost = 0;
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] != 1){
					nCost = curr.cost;
					if(curr.dir == i) {
						nCost += 100;
					} else {
						nCost += 600;
					}
					if(visited[nx][ny][i] > nCost) {
						visited[nx][ny][i] = nCost;
						q.add(new Node(nx, ny, i, nCost));
					}
				}
			}
		}
		return Arrays.stream(visited[n - 1][n - 1]).min().getAsInt();
	}
}