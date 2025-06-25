import java.util.*;
public class 광물캐기 {
    static class Mineral {
        int dia, iron, stone;

        Mineral(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
        // 피로도 계산
        int score() {
            return dia * 25 + iron * 5 + stone * 1;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int totalPicks = 0;
        for(int pick : picks) {
            totalPicks += pick;
        }
        // 5개씩 정렬
        List<Mineral> list = new ArrayList<>();

        for(int i = 0; i < minerals.length; i += 5) {
            if(totalPicks == 0) break;

            int dia = 0, iron = 0, stone = 0;

            for(int j = i; j < i + 5; j++) {
                if(j == minerals.length) break;
                String mineral = minerals[j];
                if(mineral.equals("diamond")) dia++;
                if(mineral.equals("iron")) iron++;
                if(mineral.equals("stone")) stone++;
            }

            list.add(new Mineral(dia, iron, stone));
            totalPicks--;
        }

        // 피로도 높은 순으로 정렬
        Collections.sort(list, ((a, b) -> b.score() - a.score()));

        for(Mineral m : list) {
            int dia = m.dia;
            int iron = m.iron;
            int stone = m.stone;

            if(picks[0] > 0) {
                answer += dia;
                answer += iron;
                answer += stone;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0) {
                answer += dia * 5;
                answer += iron;
                answer += stone;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0) {
                answer += dia * 25;
                answer += iron * 5;
                answer += stone;
                picks[2]--;
                continue;
            }
        }

        return answer;
    }
}