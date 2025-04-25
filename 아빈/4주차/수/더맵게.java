import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //항상 정렬을 유지해야하기 때문에
        //우선순위 큐는 자동으로 정렬
        PriorityQueue<Integer> spicy = new PriorityQueue<>();
        for(int sp : scoville){
            spicy.add(sp);
        }
        // 우선순위 큐 요소가 1개이면 끝까지 음식을 섞은거임
        while(spicy.size() >= 2 && spicy.peek() < K){
            int f = spicy.poll();
            int s = spicy.poll();
            int mix = f + s * 2;
            spicy.add(mix);
            answer++;
        }
        //마지막까지 섞어도 스코빌지수 K 보다 낮으면 -1 반환
        return spicy.peek() >= K ? answer : -1;
    }
}