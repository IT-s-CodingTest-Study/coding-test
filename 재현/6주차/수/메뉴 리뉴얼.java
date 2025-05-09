import java.util.*;

class Solution {

    static Map<String, Integer> map;
    static int max;

    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        // cr 수 에 맞는 경우의 수를 모두 구해 map에 추가
        for (int cr : course) {
            map = new HashMap<>();
            max = 0;

            // dfs를 통해 cr에 해당하는 모든 경우의 수 구하기
            for (String order : orders) {
                char[] chs = order.toCharArray();
                Arrays.sort(chs);
                dfs(chs, new StringBuilder(), 0, cr);
            }

            // 가장 많은 횟수 구하기
            for (int count : map.values()) {
                if (count > max) {
                    max = count;
                }
            }
            
            // 결과에 추가하기
            for (String key : map.keySet()) {
                if (map.get(key) == max && max >= 2) {
                    result.add(key);
                }
            }
        }

        // 사전순 정렬
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    // dfs 경우의 수 구하기
    static void dfs(char[] chs, StringBuilder sb, int idx, int cr) {
        if (sb.length() == cr) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < chs.length; i++) {
            sb.append(chs[i]);
            dfs(chs, sb, i + 1, cr);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
