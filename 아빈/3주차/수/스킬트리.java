import java.util.*;
class 스킬트리 {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (String tree : skill_trees) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < tree.length(); i++) {
				char c = tree.charAt(i);
				if (skill.contains(String.valueOf(c))) {
					sb.append(c);
				}
			}

			if (skill.startsWith(sb.toString())) {
				answer++;
			}
		}

		return answer;
	}
}