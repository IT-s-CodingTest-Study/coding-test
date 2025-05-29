import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target이 words에 없는 경우
        if (!Arrays.asList(words).contains(target))
            return 0;

        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word cur = queue.poll();

            if (cur.str.equals(target)) {
                return cur.count;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChange(cur.str, words[i])) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], cur.count + 1));
                }
            }
        }

        return 0; // target 도달 불가능한 경우
    }

    // 한 글자만 다른지 확인
    private boolean canChange(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
            if (diff > 1)
                return false;
        }
        return diff == 1;
    }

    // 현재 단어와 변환 횟수를 저장할 클래스
    private static class Word {
        String str;
        int count;

        Word(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }
}
