class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String sk : skill_trees) {
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < sk.length(); i++) {
                if (skill.contains(String.valueOf(sk.charAt(i)))) {
                    sb.append(sk.charAt(i));
                }
            }
            
            if (skill.substring(0, sb.length()).equals(sb.toString())) {
                answer++;
            }
            
        }
        
        return answer;
    }
}