class Solution {
    int count = 0;

    public int solution(int[] numbers, int target) {
        DFS(numbers, 0, 0, target); // DFS 탐색 시작: sum = 0, depth = 0
        return count; // 모든 경우 탐색 후 최종 반환
    }

    void DFS(int[] numbers, int depth, int sum, int target) {
        if (depth == numbers.length) { // 모든 숫자를 다 사용했는지 확인
            if (sum == target) { // 목표 숫자에 도달했으면 count 증가
                count++;
            }
            return; // 탐색 종료
        }

        // 현재 숫자를 더하는 경우
        DFS(numbers, depth + 1, sum + numbers[depth], target);
        // 현재 숫자를 빼는 경우
        DFS(numbers, depth + 1, sum - numbers[depth], target);
    }
}
