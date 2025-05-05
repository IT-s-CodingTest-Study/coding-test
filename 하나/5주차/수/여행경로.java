import java.util.*;
class 여행경로 {
    List<String> answer = null;
    
    public String[] solution(String[][] tickets) {
        //각 항공권이 사용됐는지 체크
        boolean[] visited = new boolean[tickets.length];
        //현재까지 경로 저장
        List<String> route = new ArrayList<>();
        route.add("ICN"); //ICN에서 시작
        
        dfs("ICN", route, visited, tickets);
        
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String current, List<String> route, boolean[] visited, String[][] tickets){
        //모든 항공권을 다 사용했을 경우 
        if(route.size() == tickets.length + 1){
           if(answer == null || String.join("",route).compareTo(String.join("", answer))<0){
               //정답이 비어있거나, 현재 경로가 알파벳 순으로 더 빠르면 정답으로
               answer = new ArrayList<>(route);
           }
            return;
        }
        //아직 항공권이 남은 경우
        for(int i = 0; i<tickets.length; i++){
             //해당 항공권을 아직 안 썼고 출발지가 현재 위치와 일치할 경우
            if(!visited[i]&&tickets[i][0].equals(current)){
                visited[i] = true; //항공권 사용 표시
                route.add(tickets[i][1]); //도착지 추가
                dfs(tickets[i][1],route,visited,tickets); //재귀 탐색
                visited[i] = false; // 사용 표시 해제
                route.remove(route.size() - 1); //도착지 제거
            }
        }
    }
}
