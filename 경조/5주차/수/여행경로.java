import java.util.*;
public class 여행경로 {
    ArrayList<String[]> pathList = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer;
        String[] path = new String[tickets.length+1];
        boolean[] visited = new boolean[tickets.length];
        path[0] = "ICN";
        dfs("ICN", path, tickets, 0, visited);
        // 저장된 경로들 알파벳 순서로 정렬
        Collections.sort(pathList, (a, b) -> {
            for(int i = 0; i < a.length; i++) {
                int cmp = a[i].compareTo(b[i]);
                if(cmp != 0) { return cmp; }
            }
            return 0;
        });
        answer = pathList.get(0);
        return answer;
    }

    private void dfs(String current, String[] path, String[][] tickets, int cnt, boolean[] visited) {
        if(cnt == tickets.length) {
            pathList.add(path.clone());			    // 새로운 배열을 복사해서 넣어줌
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(current.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                String next = tickets[i][1];        // 다음 목적지
                path[cnt+1] = next;
                dfs(next, path, tickets, cnt+1, visited);   // 다음 목적지 방문
                // 다음 목적지 방문했으면 현재 공항 방문기록 지우기(백트래킹)
                visited[i] = false;
            }
        }
    }
}
