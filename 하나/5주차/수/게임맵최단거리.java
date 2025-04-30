import java.util.*;

class 게임맵최단거리 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        
        //상하좌우 방향 
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            
            //현재 위치에서 4방향으로 이동
            for(int[] dir : directions){
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                //맵 범위 안이고, 아직 방문하지 않은 통로일 경우 
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] ==1){
                    //이동 거리 업데이트
                    maps[nx][ny] = maps[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        int result = maps[n-1][m-1];
         return result == 1 ? -1 : result;
    }
}
   
