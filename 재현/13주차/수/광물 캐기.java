import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        List<int[]> groups = new ArrayList<>();
        
        for (int i = 0; i < minerals.length && groups.size() < totalPicks; i += 5) {
            int dia = 0;
            int iron = 0;
            int stone = 0;
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                if (minerals[j].equals("diamond")) dia++;
                else if (minerals[j].equals("iron")) iron++;
                else stone++;
            }
            groups.add(new int[]{dia, iron, stone});
        }
        
        groups.sort((a, b) -> {
            int aSum = a[0] * 25 + a[1] * 5 + a[2];
            int bSum = b[0] * 25 + b[1] * 5 + b[2];
            return bSum - aSum;
        });
        
        int fatigue = 0;
        int groupIdx = 0;
        
        for (int pickType = 0; pickType < 3; pickType++) {
            while(picks[pickType] > 0 && groupIdx < groups.size()) {
                int[] g = groups.get(groupIdx++);
                fatigue += g[0] * getFatigue(pickType, 0);
                fatigue += g[1] * getFatigue(pickType, 1);
                fatigue += g[2] * getFatigue(pickType, 2);
                picks[pickType]--;
            }
        }
        
        return fatigue;
    }
    
    public int getFatigue(int pickType, int mineralType) {
        if (pickType == 0)  return 1;
        if (pickType == 1)  return new int[]{5, 1, 1}[mineralType];
        return new int[]{25, 5, 1}[mineralType];
    }
}