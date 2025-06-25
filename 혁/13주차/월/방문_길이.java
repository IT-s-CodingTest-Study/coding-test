package 월;

import java.util.HashSet;
import java.util.Set;

public class 방문_길이 {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int x = 0, y = 0;
        for (char d : dirs.toCharArray()) {
            int dir = -1;
            switch (d) {
                case 'U':
                    dir = 0;
                    break;
                case 'D':
                    dir = 1;
                    break;
                case 'R':
                    dir = 2;
                    break;
                case 'L':
                    dir = 3;
                    break;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            String path = x + "," + y + "->" + nx + "," + ny;
            String reversePath = nx + "," + ny + "->" + x + "," + y;

            visited.add(path);
            visited.add(reversePath);

            x = nx;
            y = ny;
        }
        return visited.size() / 2; // 양방향 저장했기 때문에 나누기 2
    }
}


