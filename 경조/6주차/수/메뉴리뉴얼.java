import java.util.*;
class 메뉴리뉴얼 {
    // <String, Integer> 형태로 저장
    Map<String, Integer> map = new HashMap<>();
    List<String> answerList = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        // 코스 길이별 반복
        for(int courseLength : course) {
            // 주문별 반복
            for(String order : orders) {
                char[] orderChar = order.toCharArray();
                Arrays.sort(orderChar);
                combination(new StringBuilder(), orderChar, courseLength, 0);
            }
            if(!map.isEmpty()) {
                // 최대값 찾기
                int max = Collections.max(map.values());
                if(max >= 2) {
                    for(String key : map.keySet()) {
                        if(map.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
                // 해시맵 초기화
                map.clear();
            }
        }
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public void combination(StringBuilder path, char[] order, int courseLength, int index) {
        // path 길이가 course의 길이와 같으면 탈출
        if(path.length() == courseLength) {
            String combo = path.toString();
            map.put(combo, map.getOrDefault(combo, 0) + 1);
            return;
        }

        for(int i = index; i < order.length; i++) {
            path.append(order[i]);
            combination(path, order, courseLength, i + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}