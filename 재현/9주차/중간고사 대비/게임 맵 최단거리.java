import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] visited;
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Point> q = new LinkedList<>();
        visited = new int[n][m];
        
        q.add(new Point(0, 0));
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc] != 0 || maps[nr][nc] == 0) continue;
                
                q.add(new Point(nr, nc));
                visited[nr][nc] = visited[now.r][now.c] + 1;
            }
        }
        
        int answer = visited[n - 1][m - 1];
        return answer == 0 ? -1 : answer;
    }
}

class Point {
    int r, c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

