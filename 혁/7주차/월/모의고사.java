package 월;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    static int[] list1 = {1, 2, 3, 4, 5};
    static int[] list2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] list3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == list1[i % list1.length]) score[0]++;
            if (answers[i] == list2[i % list2.length]) score[1]++;
            if (answers[i] == list3[i % list3.length]) score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}

