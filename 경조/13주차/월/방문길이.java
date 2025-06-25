public class 방문길이 {
    public int solution(String dirs) {
        int answer = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        // 좌우상하 -> 0, 1, 2, 3
        boolean[][][] visited = new boolean[11][11][4];

        int x = 5;
        int y = 5;
        int d = -1;
        for(char dir : dirs.toCharArray()) {
            // 좌우상하 순서
            if(dir == 'L') d = 0;
            if(dir == 'R') d = 1;
            if(dir == 'U') d = 2;
            if(dir == 'D') d = 3;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(check(nx, ny)) {
                if(!visited[nx][ny][d]) {
                    // 반대방향
                    int opposite = (d % 2) == 0 ? d + 1 : d - 1;
                    // 방문한 곳 <-> 왔던 곳 양방향으로 방문 추가
                    visited[x][y][opposite] = true;
                    visited[nx][ny][d] = true;
                    answer++;
                }
                x = nx;
                y = ny;
            }
        }

        return answer;
    }

    private boolean check(int x, int y) {
        return (x >= 0) && (x < 11) && (y >= 0) && (y < 11);
    }
}