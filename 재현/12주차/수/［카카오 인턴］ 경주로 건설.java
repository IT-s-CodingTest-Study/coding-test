import java.util.*;
class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(int[][] board) {
        
        int n = board.length;
        int[][][] cost = new int[n][n][4];
        for (int[][] plane : cost) {
            for (int[] row : plane) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));
        pq.add(new Point(0, 0, -1, 0));
        
        while(!pq.isEmpty()) {
            Point now = pq.poll();
            
            if (now.dir >= 0 && now.cost > cost[now.r][now.c][now.dir])
                continue;
            
            if (now.r == n - 1 && now.c == n - 1) return now.cost;
            
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (board[nr][nc] == 1) continue;
                
                int newCost = now.cost + ((now.dir == -1 || now.dir == d) ? 100 : 600);
                
                if (newCost < cost[nr][nc][d]) {
                    cost[nr][nc][d] = newCost;
                    pq.add(new Point(nr, nc, d, newCost));
                }

            }
        }
        return -1;
    }
}

class Point {
    int r, c, dir, cost;
    Point(int r, int c, int dir, int cost) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.cost = cost;
    }
}