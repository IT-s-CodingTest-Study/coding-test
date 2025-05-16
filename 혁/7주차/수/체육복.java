package 수;

import java.util.*;

public class 체육복 {
    public class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            List<Integer> lostList = new ArrayList<>();
            List<Integer> reserveList = new ArrayList<>();

            for (int l : lost) {
                lostList.add(l);
            }
            for (int r : reserve) {
                reserveList.add(r);
            }
            List<Integer> intersection = new ArrayList<>();
            for (int l : lost) {
                if (reserveList.contains(l)) {
                    intersection.add(l);
                }
            }
            for (int i : intersection) {
                lostList.remove((Integer) i);
                reserveList.remove((Integer) i);
            }
            Collections.sort(lostList);
            Collections.sort(reserveList);
            for (int r : reserveList) {
                if (lostList.contains(r - 1)) {
                    lostList.remove((Integer) (r - 1));
                } else if (lostList.contains(r + 1)) {
                    lostList.remove((Integer) (r + 1));
                }
            }
            return n - lostList.size();
        }
    }

}
