import java.util.*;
class Solution {
	public int solution(String begin, String target, String[] words) {
		if(!Arrays.asList(words).contains(target)) return 0;

		Queue<Word> q = new LinkedList<>();
		boolean[] visited = new boolean[words.length];

		q.offer(new Word(begin, 0));

		while(!q.isEmpty()) {
			Word curr = q.poll();

			if(curr.word.equals(target)) {
				return curr.depth;
			}

			for(int i = 0; i < words.length; i++){
				if(!visited[i] && canChange(curr.word, words[i])) {
					visited[i] = true;
					q.offer(new Word(words[i], curr.depth + 1));
				}
			}
		}
		return 0;
	}

	private boolean canChange(String word, String changeWord) {
		int diff = 0;
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) != changeWord.charAt(i)) {
				diff++;
			}
			if(diff > 1) {
				return false;
			}
		}
		return true;
	}

	class Word {
		String word;
		int depth;

		Word(String word, int depth){
			this.word = word;
			this.depth = depth;
		}
	}
}