import java.util.*;

class 전력망을둘로나누기 {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        for(int i = 0; i<wires.length; i++){
            //그래프 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for(int j = 0; j <= n; j++){
                graph.add(new ArrayList<>());
            }
            
            //i번째 전선을 제거한 그래프 구성
            for(int j = 0; j < wires.length; j++){
                if(i==j) continue; //전선을 끊음
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            //한 쪽 트리의 노드 개수 계산
            int count = bfs(1, graph, n);
            //두 트리의 차이 계산
            int diff = Math.abs(n-count-count);
            answer = Math.min(answer, diff);
        }
        return answer;
    }
    
    private int bfs(int start, List<List<Integer>> graph, int n){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        int count = 1;
        
        //현재 노드 이웃 노드를 방문하며 큐에 추가
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int next : graph.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        //트리의 한 쪽 노드 수 반환
        return count;
    }
}
