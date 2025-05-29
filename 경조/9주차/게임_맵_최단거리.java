import java.util.*;
public class 게임_맵_최단거리 {
    int n;
    int m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        // 상하좌우
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        boolean[][] visited = new boolean[n][m];
        Deque<Move> queue = new ArrayDeque<>();
        queue.offer(new Move(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Move cur = queue.poll();

            if (cur.row == n - 1 && cur.col == m - 1) return cur.dist;

            // 방문할 수 있는 좌표 구하기
            for(int i = 0; i < 4; i++) {
                int nr = cur.row + dr[i];
                int nc = cur.col + dc[i];
                if(check(nr, nc) && !visited[nr][nc]) {
                    // 벽인지 땅인지 확인
                    if(maps[nr][nc] == 1) {
                        queue.offer(new Move(nr, nc, cur.dist + 1));
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        return -1;
    }

    public boolean check(int row, int col) {
        return (row >= 0) && (row < n) && (col >= 0) && (col < m);
    }

    public class Move {
        int row;
        int col;
        int dist;

        Move(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}