import java.util.*;
public class 경주로_건설 {
    public class Move {
        int row, col, cost, dir;

        Move(int row, int col, int cost, int dir) {
            this.row = row;
            this.col = col;
            this.cost = cost;
            this.dir = dir;
        }
    }

    int N;
    public int solution(int[][] board) {
        N = board.length;
        // 상하좌우에서 도착한 기준
        // 방향 상하좌우 -> 0, 1, 2, 3
        int[][][] visited = new int[N][N][4];

        for(int[][] grid : visited) {
            for(int[] row : grid) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        // 상하좌우 이동
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        Queue<Move> queue = new ArrayDeque<>();
        queue.offer(new Move(0, 0, 0, -1));

        // bfs
        while(!queue.isEmpty()) {
            Move cur = queue.poll();

            if(cur.row == N - 1 && cur.col == N - 1) continue;

            // 방문할 수 있는 좌표 구하기
            for(int dir = 0; dir < 4; dir++) {
                int nr = cur.row + dr[dir];
                int nc = cur.col + dc[dir];
                int nextCost = cur.cost;
                if(check(nr, nc) && board[nr][nc] == 0) {
                    if(cur.dir == -1 || cur.dir == dir) {
                        nextCost += 100;    // 직선
                    } else {
                        nextCost += 600;    // 코너
                    }

                    if(nextCost < visited[nr][nc][dir]) {
                        queue.offer(new Move(nr, nc, nextCost, dir));
                        visited[nr][nc][dir] = nextCost;
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            answer = Math.min(answer, visited[N-1][N-1][i]);
        }

        return answer;
    }

    public boolean check(int r, int c) {
        return (r >= 0) && (r < N) && (c >= 0) && (c < N);
    }
}