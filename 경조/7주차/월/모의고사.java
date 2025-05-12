import java.util.*;
public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == arr1[i % arr1.length]) scores[0]++;
            if(answers[i] == arr2[i % arr2.length]) scores[1]++;
            if(answers[i] == arr3[i % arr3.length]) scores[2]++;
        }

        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(scores[i] == maxScore) {
                result.add(i+1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
