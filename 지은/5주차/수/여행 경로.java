import java.util.*;

public class Solution {
    boolean[] visited; // 티켓 사용 여부
    List<String> answer = new ArrayList<>(); // 경로들을 문자열로 저장

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length]; // 티켓 수만큼 visited 초기화

        // 티켓을 출발지 → 도착지 기준으로 사전순 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0]))
                return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        // 경로를 저장할 리스트 항상 ICN 출발
        List<String> route = new ArrayList<>();
        route.add("ICN");

        // DFS 탐색
        DFS(0, "ICN", route, tickets);

        // 사전순으로 가장 앞선 경로만 반환
        return answer.get(0).split(" ");
    }

    void DFS(int idx, String start, List<String> route, String[][] tickets) {
        // 모든 티켓을 사용한 경우 = 경로 완성
        if (idx == tickets.length) {
            answer.add(String.join(" ", route)); // 공백 구분하여 문자열로 저장
            return;
        }

        // 현재 위치에서 출발 가능한 모든 티켓 탐색
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true; // 티켓 사용
                route.add(tickets[i][1]); // 도착지 추가
                DFS(idx + 1, tickets[i][1], route, tickets); // 다음 공항으로 이동
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }
}
