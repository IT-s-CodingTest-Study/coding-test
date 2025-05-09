import java.util.*;

class Solution {
    // 중복된 경우의 수를 지우기 위한 Set
    Set<Integer> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
         // dfs를 이용하여 완전 탐색
        dfs(user_id, banned_id, 0, 0);
        return result.size();
    }

    void dfs(String[] user_id, String[] banned_id, int index, int bitmask) {
        // dfs 종료 케이스
        if (index == banned_id.length) {
            result.add(bitmask);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            // i번째 유저가 사용 됐으면 continue
            if ((bitmask & (1 << i)) != 0) continue;

            if (isOk(user_id[i], banned_id[index])) {
                // bitmask에 i번째 유저 추가해준 뒤 다음 dfs 실행
                dfs(user_id, banned_id, index + 1, bitmask | (1 << i));
            }
        }
    }

    // user_id가 banned_id에 부합하는지 확인
    boolean isOk(String uid, String bid) {
        if (uid.length() != bid.length()) return false;
        for (int i = 0; i < uid.length(); i++) {
            if (bid.charAt(i) != '*' && bid.charAt(i) != uid.charAt(i)) return false;
        }
        return true;
    }
}
