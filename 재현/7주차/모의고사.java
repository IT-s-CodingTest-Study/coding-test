import java.util.*;

class Solution {
    static int[] first = {1, 2, 3, 4, 5};
    static int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] answer = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (first[i % first.length] == answers[i])      answer[0]++;
            if (second[i % second.length] == answers[i])    answer[1]++;
            if (third[i % third.length] == answers[i])      answer[2]++;
        }
        
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (answer[i] == max) {
                result.add(i + 1);
            }
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}