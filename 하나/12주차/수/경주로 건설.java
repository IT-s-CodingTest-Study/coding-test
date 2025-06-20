import java.util.*;

class Solution {
    // 상, 하, 좌, 우
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        return bfs(board);
    }
    
    public int bfs(int[][] board){
        int n = board.length;
        int[][][] cost = new int[n][n][4]; // 방향별 최소 비용
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        
 
        if (board[0][1] == 0) {
            q.offer(new int[]{0, 1, 3, 100}); 
            cost[0][1][3] = 100;
        }
        if (board[1][0] == 0) {
            q.offer(new int[]{1, 0, 1, 100});
            cost[1][0][1] = 100;
        }
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];
            int curCost = cur[3];
            
            // 도착점 도달하면 계속 탐색하면서 최소값 찾기
            if (x == n-1 && y == n-1) continue;
            
            // 4방향으로 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 0) {
                    int nextCost = curCost;
                    
                    // 직선이면 100, 코너면 600
                    if (dir == d) {
                        nextCost += 100;
                    } else {
                        nextCost += 600; // 100 + 500
                    }
                    
                    if (cost[nx][ny][d] > nextCost) {
                        cost[nx][ny][d] = nextCost;
                        q.offer(new int[]{nx, ny, d, nextCost});
                    }
                }
            }
        }
        
        // 도착점까지 4방향 중 최소 비용 구하기
        return Math.min(Math.min(cost[n-1][n-1][0], cost[n-1][n-1][1]),
                        Math.min(cost[n-1][n-1][2], cost[n-1][n-1][3]));
    }
}
