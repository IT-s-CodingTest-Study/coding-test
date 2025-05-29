import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
      Map<String, Set<String>> reportMap = new HashMap<>();
      Map<String, Integer> reportedCount = new HashMap<>();

      for(String r : new HashSet<>(Arrays.asList(report))){
        String[] parts = r.split(" ");
        String reporter = parts[0], target = parts[1];
        reportMap.computeIfAbsent(reporter, v -> new HashSet<>()).add(target);
        reportedCount.put(target, reportedCount.getOrDefault(target, 0)+1);
    }
       Set<String> banned = new HashSet<>();
        for (String name : reportedCount.keySet()) {
            if (reportedCount.get(name) >= k) {
                banned.add(name);
            }
        }
      
      int[] answer = new int[id_list.length];
      for(int i = 0; i < id_list.length; i++){
        Set<String> targets = reportMap.getOrDefault(id_list[i], Collections.emptySet());
        for(String t : targets){
          if(banned.contains(t)){
            answer[i]++;
         }
       }
     } return answer;
      
    }
}
