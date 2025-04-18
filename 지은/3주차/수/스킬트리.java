class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String skillTree = skill_trees[i];
            int index = 0;
            boolean isValid = true;

            for (int j = 0; j < skillTree.length(); j++) {
                char c = skillTree.charAt(j);
                int skillIndex = skill.indexOf(c);

                if (skillIndex == -1) {
                    // skill에 없는 스킬이라면 무시
                    continue;
                }

                if (skillIndex > index) {
                    // 선행 스킬을 건너뛰었음 → 잘못된 스킬트리
                    isValid = false;
                    break;
                }

                if (skillIndex == index) {
                    // 올바른 순서의 스킬 → 다음 순서로 
                    index++;
                }
            }

            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}
