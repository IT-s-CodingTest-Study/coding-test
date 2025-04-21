class Solution {
    public int solution(int[][] arr) {
    
        int size = arr[0].length;
        
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (arr[i][j] != arr[j][i])
                    return 0;
            }
        }
        return 1;

    }
}