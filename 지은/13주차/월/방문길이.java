import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;

        for (char d : dirs.toCharArray()) {
            int nx = x, ny = y; // 이동 후 위치 초기화

            // 각 방향에 맞게 좌표 변경
            if (d == 'U')
                ny++;
            else if (d == 'D')
                ny--;
            else if (d == 'L')
                nx--;
            else if (d == 'R')
                nx++;

            // 범위 벗어나면 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5)
                continue;

            // 이동한 경로 문자열로 저장(두 방향 모두 저장하기)
            String path = x + "," + y + "," + nx + "," + ny;
            String reverse = nx + "," + ny + "," + x + "," + y;
            visited.add(path);
            visited.add(reverse);

            // 위치 갱신
            x = nx;
            y = ny;
        }

        // 한 길을 양 방향으로 저장했어서 2로 나눈 후 리턴
        return visited.size() / 2;
    }
}
