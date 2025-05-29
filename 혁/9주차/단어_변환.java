import java.util.*;

public class 단어_변환 {
    public int solution(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        q.add(new Word(begin, 0));
        while (!q.isEmpty()) {
            Word cur = q.poll();
            if (cur.word.equals(target)) return cur.count;
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && countDiff(cur.word, target) == 1) {
                    visited[i] = true;
                    q.add(new Word(words[i], cur.count + 1));
                }
            }
        }
        return 0;
    }
    class Word{
        int count;
        String word;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    int countDiff(String word, String target){
        int diffCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount;
    }
}
