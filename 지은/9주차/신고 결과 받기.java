import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>(); // key: 피신고자, value: 신고자 Set
        Map<String, Integer> mailCount = new HashMap<>(); // key: 유저, value: 메일 수

        for (String id : id_list) {
            mailCount.put(id, 0); // 메일 수 초기화
        }

        // 1. 신고 기록 처리 (중복 제거)
        Set<String> uniqueReport = new HashSet<>(Arrays.asList(report));
        for (String rep : uniqueReport) {
            String[] split = rep.split(" ");
            String from = split[0];
            String to = split[1];

            reportMap.putIfAbsent(to, new HashSet<>());
            reportMap.get(to).add(from);
        }

        // 2. 정지 유저 판별 및 신고자에게 메일 발송
        for (String reported : reportMap.keySet()) {
            Set<String> reporters = reportMap.get(reported);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    mailCount.put(reporter, mailCount.get(reporter) + 1);
                }
            }
        }

        // 3. 결과 배열 작성
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.get(id_list[i]);
        }

        return answer;
    }
}
