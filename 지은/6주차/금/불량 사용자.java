import java.util.*;

class Solution {
    Set<Set<String>> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, new HashSet<>(), 0);
        return resultSet.size();
    }

    // banned_id[index]에 매칭 가능한 user_id를 탐색
    void dfs(String[] user_id, String[] banned_id, Set<String> selected, int index) {
        if (index == banned_id.length) {
            resultSet.add(new HashSet<>(selected)); // 조합 저장
            return;
        }

        String currentPattern = banned_id[index];

        for (String user : user_id) {
            if (selected.contains(user))
                continue; // 이미 사용된 ID 제외

            if (check(user, currentPattern)) { // 패턴 일치 시 선택
                selected.add(user);
                dfs(user_id, banned_id, selected, index + 1); // 다음 패턴
                selected.remove(user); // 백트래킹
            }
        }
    }

    // user가 banned 패턴과 일치하는지 확인
    boolean check(String user, String pattern) {
        if (user.length() != pattern.length())
            return false;

        // 각 자리 비교: *는 통과, 나머진 정확히 일치해야 됨
        for (int i = 0; i < user.length(); i++) {
            if (pattern.charAt(i) == '*')
                continue;
            if (user.charAt(i) != pattern.charAt(i))
                return false;
        }

        return true;
    }
}
