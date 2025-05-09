import java.util.*;
public class 불량사용자 {
    // 중복 저장 x
    Set<Set<String>> resultSet = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        dfs(new HashSet<>(), user_id, banned_id, 0);
        return resultSet.size();
    }

    public void dfs(Set<String> currentSet, String[] user_id, String[] banned_id, int depth) {
        if(depth == banned_id.length) {
            // 깊은 복사 (저장된 이후로 값이 갱신되지 않도록 함)
            resultSet.add(new HashSet<>(currentSet));
            return;
        }

        for(String user : user_id) {
            if(currentSet.contains(user)) continue;
            if(isMatch(user, banned_id[depth])) {
                currentSet.add(user);
                dfs(currentSet, user_id, banned_id, depth + 1);
                currentSet.remove(user);
            }
        }
    }

    public boolean isMatch(String user, String banned) {
        if(user.length() != banned.length()) return false;
        for(int i = 0; i < user.length(); i++) {
            if(banned.charAt(i) == '*') continue;
            if(user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }
}
