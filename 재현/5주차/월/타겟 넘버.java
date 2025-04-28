class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) { 
        
        bfs(0, 0, numbers, target);
        return answer;
    }
    
    static void bfs(int sum, int index, int[]numbers, int target) {
        if (index == numbers.length) {
            if (sum == target)  answer++;
        }        
        
        if (index < numbers.length) {
            bfs(sum + numbers[index], index + 1, numbers, target);
            bfs(sum - numbers[index], index + 1, numbers, target);    
        }
    }
}