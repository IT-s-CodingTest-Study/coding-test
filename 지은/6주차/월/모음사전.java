import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    char[] ch = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        DFS("", 0);
        return list.indexOf(word) + 1;
    }

    // current : 현재까지 만든 단어
    // depth : 현재 단어까지의 길이 (최대 5개)
    void DFS(String current, int depth) {
        if (depth > 5) return;

        // 빈 문자열 제외
        if (!current.equals("")) {
            list.add(current);
        }

        // 재귀 호출
        for (char c : ch) {
            DFS(current + c, depth + 1);
        }
    }
}
