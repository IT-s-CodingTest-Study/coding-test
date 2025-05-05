import java.util.*;

public class 모음사전 {
    static String[] words = {"A", "E", "I", "O", "U"};
    static int answer = 0;
    static int count = 0;
    static boolean found = false;

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    private void dfs(String current, String target) {
        if (found) return;

        if (!current.isEmpty()) {
            count++;
            if (current.equals(target)) {
                answer = count;
                found = true;
                return;
            }
        }

        if (current.length() == 5) return;

        for (String w : words) {
            dfs(current + w, target);
        }
    }
}
