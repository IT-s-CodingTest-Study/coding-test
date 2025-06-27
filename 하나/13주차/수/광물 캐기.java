import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int total = 0;

        // 총 사용할 수 있는 곡괭이 수만큼만 광물 자르기
        int totalPick = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(minerals.length, totalPick * 5);

        // 광물을 5개씩 그룹으로 나누기
        List<List<String>> blocks = new ArrayList<>();
        for (int i = 0; i < maxMinerals; i += 5) {
            List<String> block = new ArrayList<>();
            for (int j = i; j < i + 5 && j < maxMinerals; j++) {
                block.add(minerals[j]);
            }
            blocks.add(block);
        }

        // 각 블록의 작업 난이도 점수 계산
        List<int[]> scored = new ArrayList<>();
        for (int i = 0; i < blocks.size(); i++) {
            int score = 0;
            for (String m : blocks.get(i)) {
                if (m.equals("diamond")) score += 25;
                else if (m.equals("iron")) score += 5;
                else score += 1;
            }
            scored.add(new int[]{score, i});
        }

        // 점수 기준으로 정렬
        scored.sort((a, b) -> b[0] - a[0]);

        // 좋은 곡괭이부터 할당하며 피로도 계산
        for (int i = 0; i < scored.size(); i++) {
            int index = scored.get(i)[1];
            List<String> block = blocks.get(index);

            if (picks[0] > 0) {
                total += getFatigue(block, "diamond");
                picks[0]--;
            } else if (picks[1] > 0) {
                total += getFatigue(block, "iron");
                picks[1]--;
            } else if (picks[2] > 0) {
                total += getFatigue(block, "stone");
                picks[2]--;
            } else {
                break;
            }
        }

        return total;
    }

    // 피로도 계산 함수
    public int getFatigue(List<String> block, String tool) {
        int fatigue = 0;
        for (String m : block) {
            switch (tool) {
                case "diamond":
                    fatigue += 1;
                    break;
                case "iron":
                    fatigue += m.equals("diamond") ? 5 : 1;
                    break;
                case "stone":
                    if (m.equals("diamond")) fatigue += 25;
                    else if (m.equals("iron")) fatigue += 5;
                    else fatigue += 1;
                    break;
            }
        }
        return fatigue;
    }
}
