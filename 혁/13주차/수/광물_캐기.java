package 수;

import java.util.ArrayList;
import java.util.List;

public class 광물_캐기 {
    public int solution(int[] picks, String[] minerals) {
        int result = 0;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < minerals.length; i += 5) {
            int[] cnt = new int[3];
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                if (minerals[j].equals("diamond")) cnt[0]++;
                else if (minerals[j].equals("iron")) cnt[1]++;
                else cnt[2]++;
            }
            list.add(cnt);
        }

        list.sort((a, b) -> (b[0] * 25 + b[1] * 5 + b[2]) - (a[0] * 25 + a[1] * 5 + a[2]));

        for (int[] g : list) {
            if (picks[0]-- > 0) {
                result += g[0] + g[1] + g[2];
            } else if (picks[1]-- > 0) {
                result += g[0] * 5 + g[1] + g[2];
            } else if (picks[2]-- > 0) {
                result += g[0] * 25 + g[1] * 5 + g[2];
            } else {
                break;
            }
        }

        return result;
    }
}
