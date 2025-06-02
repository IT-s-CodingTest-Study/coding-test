import java.util.*;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 중복 신고 없애기 위한 hashSet
        Set<String> set = new HashSet<>(Arrays.asList(report));

        // 사람별 신고당한 숫자 map
        Map<String, Integer> countMap = new HashMap<>();
        // 사람별 신고한 사람 리스트 map
        Map<String, List<String>> reportWho = new HashMap<>();

        // map에 정보 넣기
        for(String r : set) {
            String[] content = r.split(" ");
            String from = content[0];
            String to = content[1];

            countMap.put(to, countMap.getOrDefault(to, 0) + 1);
            // 이전에 신고한 적이 없는 사람일 경우
            if(!reportWho.containsKey(from)) {
                reportWho.put(from, new ArrayList<>());
            }

            reportWho.get(from).add(to);
        }

        // k이상 신고당한 사람을 신고한 적 있는 사람 기준으로 찾기
        for(int i = 0; i < id_list.length; i++) {
            // 신고한 사람
            String reporter = id_list[i];

            for(String reportee : reportWho.getOrDefault(reporter, new ArrayList<>())) {
                if(countMap.get(reportee) >= k) {
                    answer[i] += 1;
                }
            }
        }


        return answer;
    }
}