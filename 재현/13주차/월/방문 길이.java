import java.util.*;
class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    String dirStr = "UDLR";
    public int solution(String dirs) {
        
        int count = 0;
        
        boolean[][][] visited = new boolean[11][11][4];
        int r = 5, c = 5;
        
        for (char ch : dirs.toCharArray()) {
            int dir = dirStr.indexOf(ch);
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            if (nr < 0 || nr > 10 || nc < 0 || nc > 10) continue;
            
            if (!visited[r][c][dir]) {
                count++;
                visited[r][c][dir] = true;
                
                int revDir = dir % 2 == 0 ? dir + 1 : dir - 1;
                visited[nr][nc][revDir] = true;
            }
            
            r = nr;
            c = nc;
        }
        return count;
    }
}