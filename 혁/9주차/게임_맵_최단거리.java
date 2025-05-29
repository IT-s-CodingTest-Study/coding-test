import java.util.*;

public class 게임_맵_최단거리 {
    static int[]dr = {0, 1, 0, -1};
    static int[]dc = {-1, 0, 1, 0};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0]; int c = cur[1]; int dist = cur[2];
            if(r == n-1 && c == m-1) return dist;
            for(int i =0; i<4; i++){
                int nr = r+dr[i]; int nc = c+dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && maps[nr][nc] == 1){
                    q.add(new int[]{nr, nc, dist+1});
                    visited[nr][nc] = true;
                }
            }
        }
        return 0;
    }
}
