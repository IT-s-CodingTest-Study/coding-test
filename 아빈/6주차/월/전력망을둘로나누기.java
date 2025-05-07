import java.util.*;

class 전력망을둘로나누기 {
    List<List<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : wires){
            int a = edge[0];
            int b = edge[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            boolean[] visited = new boolean[n + 1];
            
            graph.get(a).remove((Integer)b);
            graph.get(b).remove((Integer)a);
            int count = dfs(1, visited);
            int diffrence = Math.abs(count - (n - count));
            answer = Math.min(answer, diffrence);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return answer;
    }
    
    private int dfs(int v, boolean[] visited){
        visited[v] = true;
        int count = 1;
        for(int next : graph.get(v)){
            if(!visited[next]) {
                count += dfs(next, visited);
            }
        }
        return count;
    }
}
