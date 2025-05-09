import java.util.*;
class 불량사용자 {
    
     Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, new HashSet<>(), 0);
        return result.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, Set<String> set, int index){
        // 모든 banned_id에 대한 매핑이 끝났을 경우
        if(index == banned_id.length){
             // 순서와 관계없이 같은 조합이면 하나로 처리해야 함
             result.add(new HashSet<>(set));
             return;
        }
        
        String pattern = banned_id[index].replace("*",".");
        for(String user : user_id){
            //이미 선택된 아이디 중복 x
            if(set.contains(user)) continue;
            
            if(user.length() != pattern.length())continue;
            //정규식 패턴과 매칭되는지를 확인
            if(user.matches(pattern)){
                set.add(user);
                dfs(user_id, banned_id, set, index+1);
                set.remove(user);
            }
        }
    }
}
