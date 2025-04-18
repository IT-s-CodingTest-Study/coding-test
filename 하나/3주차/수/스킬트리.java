class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String tree : skill_trees){
            
             StringBuilder sb = new StringBuilder();

            //현재 스킬 트리 문자열의 각 문자를 하나씩 확인 
            for(int i = 0; i<tree.length(); i++){
                 char c = tree.charAt(i);
                //skill 문자열 안에 현재 문자 c가 포함되어 있는지 확인
                 if(skill.contains(String.valueOf(c))){
                     sb.append(c);
                 }
             }
            //sb에 담긴 문자열이 skill의 앞부분과 일치하는지 확인
            if(skill.startsWith(sb.toString())){
                     answer++;
            } 
        }
    
        return answer;
    }
}
