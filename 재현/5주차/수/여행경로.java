import java.util.*;

class Solution {
    
    static Deque<String> dq = new ArrayDeque<>();
    static boolean[] used;
    
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        used = new boolean[tickets.length]; 
        
        dq.addLast("ICN");
        dfs("ICN", tickets, 0);
        
        String[] answer = dq.toArray(new String[0]);
        return answer;
    }
    
    static boolean dfs(String to, String[][] tickets, int count) {
        if (count == tickets.length) {
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(to)) {
                used[i] = true;
                dq.addLast(tickets[i][1]);
                
                if (dfs(tickets[i][1], tickets, count + 1)) {
                    return true;
                }
                
                used[i] = false;
                dq.pollLast();
            }
        }
        return false;
    }
}