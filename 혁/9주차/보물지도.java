import java.util.*;

public class 보물지도 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static int[] dr2 = {0, 2, 0, -2};
    static int[] dc2 = {-2, 0, 2, 0};

    class State {
        int r;
        int c;
        int dist;
        int jumped;

        State(int r, int c, int dist, int jumped) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.jumped = jumped;
        }
    }

    public int solution(int n, int m, int[][] hole) {
        Queue<State> q = new LinkedList<>();
        int[][] maps = new int[m][n];
        for (int[] h : hole) {
            maps[h[1] - 1][h[0] - 1] = 1;
        }
        boolean[][][] visited = new boolean[m][n][2];
        q.offer(new State(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.r == m - 1 && cur.c == n - 1) return cur.dist;
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && maps[nr][nc] == 0) {
                    if (!visited[nr][nc][cur.jumped]) {
                        q.offer(new State(nr, nc, cur.dist + 1, cur.jumped));
                        visited[nr][nc][cur.jumped] = true;
                    }
                }
            }
            if (cur.jumped == 0) {
                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr2[i];
                    int nc = cur.c + dc2[i];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && maps[nr][nc] == 0) {
                        if (!visited[nr][nc][cur.jumped]) {
                            q.offer(new State(nr, nc, cur.dist + 1, cur.jumped + 1));
                            visited[nr][nc][cur.jumped + 1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
