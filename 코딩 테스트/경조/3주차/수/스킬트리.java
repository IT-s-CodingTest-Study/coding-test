public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            int index = 0;
            for(int j = 0; j < skill_trees[i].length(); j++) {
                char c = skill_trees[i].charAt(j);
                // 스킬 순서에 c가 있다면
                if(skill.indexOf(c) != -1) {
                    if(c != skill.charAt(index)) {
                        index = -1;
                        break;
                    }
                    index++;
                }
            }
            if(index != -1) {
                answer++;
            }
        }
        return answer;
    }
}
