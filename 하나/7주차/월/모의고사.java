import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] user1 = {1, 2, 3, 4, 5};
        int[] user2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] user3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int score1 = 0, score2 = 0, score3 = 0;

        //정답 배열과 각 수포자의 패턴을 비교하여 점수 계산
        for(int i = 0; i < answers.length; i++){
            int a = answers[i];
            if(a == user1[i%user1.length])score1++;
            if(a == user2[i%user2.length])score2++;
            if(a == user3[i%user3.length])score3++;
        }
        
        //최고 점수 계산
        int max = Math.max(score1, Math.max(score2, score3));
       
        //최고 점수를 받은 번호 저장
        int[] temp = new int[3];
        int count = 0;
        
        if (score1 == max) temp[count++] = 1;
        if (score2 == max) temp[count++] = 2;
        if (score3 == max) temp[count++] = 3;
        
        return Arrays.copyOf(temp, count);
    }
}
