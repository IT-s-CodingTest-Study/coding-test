import java.util.*;
class 모음사전 {
    String[] char_list = {"A", "E", "I", "O", "U"};
    List<String> str_list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        dfs("");
        for(int i = 0; i < str_list.size(); i++){
           if(str_list.get(i).equals(word)){
               break;
           } 
           answer++; 
        }
        
        return answer;
    }
    
    private void dfs(String str){
        str_list.add(str);
        
        if(str.length() == 5){
            return;
        }
        for(int i = 0; i < 5; i++){
            dfs(str + char_list[i]);
        }
    }
}
