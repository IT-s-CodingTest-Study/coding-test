import java.util.*;
class Solution {
    public int solution(String dirs) {
        int x =0, y =0;
    
        Set<String> path = new HashSet<>();
        
        for(char dir : dirs.toCharArray()){
            int nx = x, ny = y;
            
            if(dir == 'U') ny++;
            else if(dir == 'D') ny--;
            else if(dir == 'R') nx++;
            else if(dir == 'L') nx--;
            
            if(nx < -5 || nx > 5 || ny <-5 ||ny >5) continue;
            
            String road = x + ","+y+","+nx+","+ny;
            String reRoad = nx + "," + ny +","+x+","+y;
            
            path.add(road);
            path.add(reRoad);
            
            x = nx;
            y = ny;
        }
        return path.size()/2;
    }
}
