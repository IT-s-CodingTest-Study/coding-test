import java.util.*;
public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 동일한 신고 1번으로 처리
        Set<String> reportSet = new HashSet<>();
        // 유저, 신고 당한 횟수
        Map<String, Integer> countMap = new HashMap<>();
        // 유저, 신고목록
        Map<String, List<String>> reportMap = new HashMap<>();

        for(String s : report) {
            reportSet.add(s);
        }

        for(String r : reportSet) {
            String[] str = r.split(" ");
            String reporter = str[0];
            String reported = str[1];

            countMap.put(reported, countMap.getOrDefault(reported, 0) + 1);
            if(!reportMap.containsKey(reporter)) reportMap.put(reporter, new ArrayList<>());
            reportMap.get(reporter).add(reported);
        }

        // 정지 목록
        List<String> banned = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() >= k) banned.add(entry.getKey());
        }

        // 정지 알림 보내기
        for(int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            for(String reported : reportMap.getOrDefault(reporter, new ArrayList<>())) {
                if(banned.contains(reported)) answer[i]++;
            }
        }

        return answer;
    }
}