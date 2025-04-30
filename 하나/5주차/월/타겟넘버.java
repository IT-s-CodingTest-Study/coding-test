class 타겟넘버 {
    int count = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }

    public void dfs(int[] numbers, int target, int depth, int result) {
        if (depth == numbers.length) {
            if (target == result) {
                count++;
            }
            return; 
        }

        int plus = result + numbers[depth];
        int minus = result - numbers[depth];

        dfs(numbers, target, depth + 1, plus);
        dfs(numbers, target, depth + 1, minus);
    }
}
