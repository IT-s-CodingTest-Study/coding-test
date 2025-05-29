import java.util.*;

class Solution {
    boolean[] visited;
    int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        if(!Arrays.asList(words).contains(target)){
            return 0;
        }
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int count){
        if(begin.equals(target)){
            answer = count;
            return;
        }
        
        for(int i = 0; i<words.length; i++){    
            if(visited[i]){
                continue;
            }
            int k = 0; //같은 스펠링의 수를 카운트
            for(int j = 0; j<begin.length(); j++){
                if(begin.charAt(j)==words[i].charAt(j)){
                    k++;
                }
            }
            //한 글자만 다른 경우
            if(k==begin.length()-1){
                visited[i] = true;
                dfs(words[i],target,words,count+1);
                visited[i] = false;
                }
            }
        }
}
