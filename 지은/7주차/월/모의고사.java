import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 각 수포자 찍는 방식 정의
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3]; // scores[0]: 1번, scores[1]: 2번, scores[2]: 3번
        
        for (int i = 0; i < answers.length; i++) {
             // 수포자들 패턴은 반복되므로 % 연산으로 인덱스 순회
            if (answers[i] == p1[i % p1.length]) scores[0]++;
            if (answers[i] == p2[i % p2.length]) scores[1]++;
            if (answers[i] == p3[i % p3.length]) scores[2]++;
        }
        
        // 세 명 중 최고 점수 찾기
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        List<Integer> list = new ArrayList<>();
        
        // 최고 점수 받은 사람 리스트에 추가
      for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                list.add(i + 1); 
            }
        }
        // int 배열로 변환
        return list.stream().mapToInt(i -> i).toArray();
    }
    
}
