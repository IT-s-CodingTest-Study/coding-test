import java.util.*;

class 여행경로 {
    boolean[] v;
    List<String> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        v = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        path.add("ICN");
        dfs("ICN", tickets, 0);
        return ans.toArray(new String[0]);
    }

    private boolean dfs(String now, String[][] tickets, int d) {
        if (d == tickets.length) {
            ans = new ArrayList<>(path);
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!v[i] && tickets[i][0].equals(now)) {
                v[i] = true;
                path.add(tickets[i][1]);
                if (dfs(tickets[i][1], tickets, d + 1)) return true;
                v[i] = false;
                path.remove(path.size() - 1);
            }
        }

        return false;
    }
}
