class Solution {
    int answer = Integer.MAX_VALUE; // 피로도 

    public int solution(int[] picks, String[] minerals) {
        // 곡괭이 하나당 최대 5개까지 광물 캘 수 있음
        int usableMinerals = Math.min(minerals.length, (picks[0] + picks[1] + picks[2]) * 5);

        dfs(picks, minerals, 0, 0, usableMinerals);
        return answer;
    }

    // 곡괭이 조합으로 최소 피로도 탐색
    void dfs(int[] picks, String[] minerals, int idx, int fatigue, int limit) {
        // 광물을 다 캤거나, 곡괭이가 없으면 종료
        if (idx >= limit || (picks[0] + picks[1] + picks[2]) == 0) {
            answer = Math.min(answer, fatigue);
            return;
        }

        // 곡괭이 하나 선택해서 5개 광물 캐기
        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0) continue;

            picks[i]--; // 곡괭이 사용
            int f = 0;

            for (int j = idx; j < idx + 5 && j < limit; j++) {
                String m = minerals[j];
                if (i == 0) f += 1; // 다이아 곡괭이
                else if (i == 1) f += m.equals("diamond") ? 5 : 1; // 철 곡괭이
                else f += m.equals("diamond") ? 25 : m.equals("iron") ? 5 : 1; // 돌 곡괭이
            }

            dfs(picks, minerals, idx + 5, fatigue + f, limit); 
            picks[i]++; 
        }
    }
}
