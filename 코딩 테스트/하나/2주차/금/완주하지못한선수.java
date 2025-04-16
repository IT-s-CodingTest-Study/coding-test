import java.util.*;
class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String, Integer> map = new HashMap<>();
    
    for(String name : participant){
    //동명이인일 경우 원래 들어간 값 + 1 
    //getOrDefault -> name이 존재하면 1 저장, 그렇지 않으면 저장되어 있는 값+1을 저장
    map.put(name, map.getOrDefault(name, 0)+1);
    }
    
    //완주자는 제거한다.(-1)
    for(String name: completion){
    map.put(name, map.get(name)-1);
    }
   
  for(String name : map.keySet()){
  if(map.get(name) != 0){
  answer = name;
  break;
      
  }
  }
        return answer;
    }
}
