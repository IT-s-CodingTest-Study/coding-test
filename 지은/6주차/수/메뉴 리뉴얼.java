import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            String order = orders[i];

            // 주문 메뉴를 알파벳 순으로 정렬
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            String sortedOrder = new String(chars);

            // 코스 길이에 대해 조합 생성
            for (int j = 0; j < course.length; j++) {
                int courseSize = course[j];
                // 조합 만들 수 있을 때만 진행
                if (sortedOrder.length() >= courseSize) {
                    // 조합 생성
                    dfs(sortedOrder, "", 0, courseSize);
                }
            }
        }

        // 각 코스 길이에 대해 가장 많이 등장한 조합만 결과에 넣기
        for (int i = 0; i < course.length; i++) {
            int courseSize = course[i];
            int maxCount = 0;

            // 해당 길이에서 가장 많이 나온 횟수(maxCount)를 찾기
            for (String key : map.keySet()) {
                if (key.length() == courseSize && map.get(key) >= 2) {
                    if (map.get(key) > maxCount) {
                        maxCount = map.get(key);
                    }
                }
            }

            // maxCount인 조합만 결과에 추가
            for (String key : map.keySet()) {
                if (key.length() == courseSize && map.get(key) == maxCount) {
                    result.add(key);
                }
            }
        }

        // 사전 순 정렬
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    // order: 정렬된 주문 문자열, current: 지금까지 만든 조합 문자열, index: 탐색 시작 위치, targetLength:
    // 목표로 하는 조합의 길이
    void dfs(String order, String current, int index, int targetLength) {
        // 목표 길이에 도달 했으면 map에 저장 또는 개수 증가
        if (current.length() == targetLength) {
            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
            return;
        }

        // 인덱스 넘었으면 종료
        if (index >= order.length())
            return;

        dfs(order, current + order.charAt(index), index + 1, targetLength); // 현재 문자를 조합에 포함하고 다음 문자로
        dfs(order, current, index + 1, targetLength); // 포함하지 않고 다음 문자로
    }
}
