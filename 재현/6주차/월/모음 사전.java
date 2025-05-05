import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        
        dfs(new StringBuilder());
        
        return list.indexOf(word);
    }

    static void dfs(StringBuilder sb) {
        if (sb.length() > 5) return;

        list.add(sb.toString());

        for (int i = 0; i < 5; i++) {
            sb.append(vowels[i]);
            dfs(sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
