import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        Set<String> reportSet = new HashSet();

        for (String rep : report) {
            reportSet.add(rep);
        }

        Map<String, Integer> count = new HashMap<>();
        Map<String, List<String>> person = new HashMap<>();

        for (String id : id_list) {
            person.put(id, new ArrayList<>());
        }

        for (String rep : reportSet) {
            StringTokenizer st = new StringTokenizer(rep, " ");
            String name1 = st.nextToken();
            String name2 = st.nextToken();

            person.get(name1).add(name2);

            count.put(name2, count.getOrDefault(name2, 0) + 1);
        }

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            int c = 0;

            List<String> result = person.get(name);

            for (String str : result) {
                if (count.get(str) >= k)
                    c++;
            }

            answer[i] = c;
        }

        return answer;
    }
}