import java.util.*;

public class 보물지도 {
    int[] dr = {0, -1, 0, 1};
    int[] dc = {1, 0, -1, 0};

    public int solution(int n, int m, int[][] hole) {
        int[][] grid = new int[m][n];

        // 함정에 1표시
        for(int[] h : hole) {
            grid[h[1] - 1][h[0] - 1] = 1;
        }

        // queue는 r, c, dist, jumped
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 0});

        // visited는 r, c, jumped
        boolean[][][] visited = new boolean[m][n][2];
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int dist = cur[2];
            int jumped = cur[3];

            if(curR == m - 1 && curC == n - 1) return dist;

            for(int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if(isValid(nextR, nextC, grid)) {
                    if(!visited[nextR][nextC][jumped]) {
                        q.offer(new int[]{nextR, nextC, dist + 1, jumped});
                        visited[nextR][nextC][jumped] = true;
                    }
                }
            }

            if(jumped == 0) {
                for(int i = 0; i < 4; i++) {
                    int nextR = curR + dr[i] * 2;
                    int nextC = curC + dc[i] * 2;

                    if(isValid(nextR, nextC, grid)) {
                        if(!visited[nextR][nextC][jumped + 1]){
                            q.offer(new int[]{nextR, nextC, dist + 1, jumped + 1});
                        }
                    }
                }
            }
        }

        return -1;
    }

    boolean isValid(int r, int c, int[][] grid) {
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length) && grid[r][c] != 1;
    }
}