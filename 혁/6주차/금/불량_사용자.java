import java.lang.reflect.Parameter;
import java.util.*;
import java.util.regex.Pattern;

public class 불량_사용자 {
    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> list = new ArrayList<>();
        for (String b : banned_id) {
            List<String> bList = new ArrayList<>();
            String regex = b.replace("*", ".");
            for (String u : user_id) {
                if (u.length() == b.length() && u.matches(regex)) {
                    bList.add(u);
                }
            }
            list.add(bList);
        }
        Set<Set<String>> allId = new HashSet<>();
        dfs(list, 0, new HashSet<>(), allId);
        return allId.size();
    }

    public void dfs(List<List<String>> list, int depth, Set<String> selectedUserId, Set<Set<String>> allId) {
        if (depth == list.size()) {
            allId.add(new HashSet<>(selectedUserId));
            return;
        }
        for (String user : list.get(depth)) {
            if (!selectedUserId.contains(user)) {
                selectedUserId.add(user);
                dfs(list, depth + 1, selectedUserId, allId);
                selectedUserId.remove(user);
            }
        }
    }
}
