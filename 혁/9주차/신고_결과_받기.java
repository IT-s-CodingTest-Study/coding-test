import java.net.Inet4Address;
import java.util.*;

public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 누가 누구를 신고했는지
        Map<String, List<String>> map1 = new HashMap<>();
        // 누가 몇번의 신고를 당했는지
        Map<String, Integer> map2 = new HashMap<>();
        //report는 중복이 되지 않는다.
        Set<String> set = new HashSet<>();
        //set에 넣어준다. report 를
        for (String s : report) {
            set.add(s);
        }
        //set에 있는걸 토대로 누가 누구를 신고했는지를 넣어줌
        for (String s2 : set) {
            String[] parts = s2.split(" ");
            String send = parts[0];
            String receive = parts[1];
            map1.putIfAbsent(send, new ArrayList<>());
            map1.get(send).add(receive);
        }
        //누가 얼마나 신고 당했는지 넣어줌
        for(String key : map1.keySet()){
            for(String s : map1.get(key)){
                map2.put(s, map2.getOrDefault(s, 0)+1);
            }
        }
        //answer에 2개 이상 들어간 사람 찾아서 정지 기준을 넘은 사람 카운트
        for(int i = 0; i<id_list.length; i++){
            for (String s2 : map1.getOrDefault(id_list[i], new ArrayList<>())) {
                if(map2.get(s2) >= k){
                    answer[i] += 1;
                }
            }
        }

        return answer;
    }
}
