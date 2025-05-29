import java.util.*;
class Solution{
    public int solution(int[][] maps) {
      int n = maps.length;
      int m = maps[0].length;

      Queue<int[]> queue = new LinkedList<>();
      queue.offer(new int[]{0,0});
      
      int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

      while(!queue.isEmpty()){
        int[] current = queue.poll();
        int x = current[0], y = current[1];

        for(int[] dir:directions){
          int nx = x + dir[0];
          int ny = y + dir[1];

          if(nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1){
            maps[nx][ny] = maps[x][y] + 1;
            queue.offer(new int[]{nx, ny});
           }
        }
     }
      int result = maps[n-1][m-1];
      return result == 1 ? -1 : result;
  }
}
