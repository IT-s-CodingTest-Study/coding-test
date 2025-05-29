import java.util.*;
public class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Deque<Word> queue = new ArrayDeque<>();

        queue.offer(new Word(begin, 0));
        while(!queue.isEmpty()) {
            Word w = queue.poll();

            if(w.word.equals(target)) return w.dist;

            // 단어가 차이가 1인지 방문을 했는지 체크
            for(int i = 0; i < words.length; i++) {
                if(diffCount(w.word, words[i]) == 1 && !visited[i]) {
                    queue.offer(new Word(words[i], w.dist + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }

    public int diffCount(String word1, String word2) {
        int count = 0;
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) count++;
        }

        return count;
    }

    public class Word {
        String word;
        int dist;

        Word(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }
}
